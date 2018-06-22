<!DOCTYPE html>
<%@ page import="com.config.web.WebConstants" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>OpenLayers example</title>
    <link rel="stylesheet" href="${contextData.openLayerJsPath}/ol.css" />
    
    <script type="text/javascript" src="${contextData.jqueryJsPath}/jquery.min.js"></script>
    <style>
      #map {
        width: 600px;
        height: 400px;
      }
    </style>
</head>
<body>
    <div id="map"></div>
    <script src="${contextData.openLayerJsPath}/ol.js"></script>
    <script>
    var map = new ol.Map({
      target: 'map',
      layers: [
        new ol.layer.Tile({
          source: new ol.source.OSM()
        })
      ],
      view: new ol.View({
        center: [0, 0],
        zoom: 4
      })
    });
    </script>
    <h1>${WebConstants.OPENLAYER_JS_PATH} </h1>
</body>
</html>