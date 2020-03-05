package com.training.map.src;

import com.esri.arcgisruntime.concurrent.ListenableFuture;
import com.esri.arcgisruntime.data.Feature;
import com.esri.arcgisruntime.data.GeoPackage;
import com.esri.arcgisruntime.data.GeoPackageFeatureTable;
import com.esri.arcgisruntime.layers.FeatureLayer;
import com.esri.arcgisruntime.loadable.LoadStatus;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.GeoElement;
import com.esri.arcgisruntime.mapping.Viewpoint;
import com.esri.arcgisruntime.mapping.popup.Popup;
import com.esri.arcgisruntime.mapping.view.IdentifyLayerResult;
import com.esri.arcgisruntime.mapping.view.MapView;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapAppModel {
    private MapView mapView;
    private List<FeatureLayer> featureLayers = new ArrayList<FeatureLayer>();

    public MapAppModel() {
        System.out.println("MapAppModel: constructor");
    }

    private void setMapListener() {
        System.out.println("MapAppModel: setMapListener");
        mapView.setOnMouseClicked(event -> {
            // check for primary or secondary mouse click
            if (event.isStillSincePress() && event.getButton() == MouseButton.PRIMARY) {
                // clear previous results
                featureLayers.forEach(featureLayer -> {
                    featureLayer.clearSelection();
                });

                Point2D point = new Point2D(event.getX(), event.getY());

                for (FeatureLayer featureLayer : featureLayers) {


                    final ListenableFuture<IdentifyLayerResult> results = mapView.identifyLayerAsync(featureLayer, point, 10,
                            false, 10);

                    results.addDoneListener(() -> {

                        try {
                            IdentifyLayerResult layer = results.get();

                            List<Feature> features = layer.getElements().stream()
                                    .filter(geoElement -> geoElement instanceof Feature)
                                    .map(g -> (Feature) g)
                                    .collect(Collectors.toList());

                            featureLayer.selectFeatures(features);

                            System.out.println(layer.getElements());
                            System.out.println(layer.getElements().size());

                            if (layer.getElements().size() > 0) {
                                System.out.println("POPUP MORE THAN 0 SIZE");
                                GeoElement identifiedPopup = layer.getElements().get(0);
                                Popup popup = new Popup(identifiedPopup);
                                popup.getPopupDefinition();
                                System.out.println(popup.getPopupDefinition());
                                System.out.println(identifiedPopup.getAttributes());


                                final Stage dialog = new Stage();
                                dialog.initModality(Modality.NONE);

                                VBox dialogVbox = new VBox(20);

                                dialogVbox.getChildren().add(new Text("This is a Dialog"));
                                Scene dialogScene = new Scene(dialogVbox, 300, 200);
                                dialog.setScene(dialogScene);
                                dialog.show();

                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
        });
    }

    public MapView getMapView() {
        return mapView;
    }

    public void setMapView(MapView mapView) {
        this.mapView = mapView;
    }

    public void setupMapView(MapView mapView) {
        this.mapView = mapView;
        setupMap();
        setMapListener();
    }

    private void setupMap() {
        System.out.println("MapAppModel: setupMap");
        if (mapView != null) {
            System.out.println("MapAppModel: setupMap - mapview!= null");
            Basemap.Type basemapType = Basemap.Type.IMAGERY;
            double latitude = 50.46;
            double longitude = 4.46;
            int levelOfDetail = 12;

            ArcGISMap map = new ArcGISMap(basemapType, latitude, longitude, levelOfDetail);
            mapView.setMap(map);
        }
    }

    public void openGeopackage(File file, StackPane stackPaneID) {

        ArcGISMap map = mapView.getMap();

        GeoPackage geoPackage = new GeoPackage(file.getAbsolutePath());
        geoPackage.loadAsync();

        // create a feature layer from the first feature table in the gpkg
        geoPackage.addDoneLoadingListener(() -> {
            if (geoPackage.getLoadStatus() == LoadStatus.LOADED) {
                List<GeoPackageFeatureTable> featureTables = geoPackage.getGeoPackageFeatureTables();
                if (featureTables.size() > 0) {
                    for (GeoPackageFeatureTable layer : featureTables) {
                        FeatureLayer featureLayer = new FeatureLayer(layer);

                        featureLayers.add(featureLayer);
                    }

                    map.getOperationalLayers().addAll(featureLayers);
                    featureLayers.get(featureLayers.size() - 1).addDoneLoadingListener(() -> {
                        mapView.setViewpointAsync(new Viewpoint(featureLayers.get(featureLayers.size() - 1).getFullExtent()));
                    });
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, geoPackage.getLoadError().getMessage());
                alert.show();
            }
        });


        mapView.setMap(map);
    }
}
