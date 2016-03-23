package openlayers

import org.w3c.dom.Element
import org.w3c.dom.events.Event

@native
object olx {
    interface GeolocationOptions {
        var projection: dynamic /* ol.proj.ProjectionLike | ol.proj.Projection */?  get() = noImpl; set(value) = noImpl
    }
    interface MapOptions {
        var controls: Any?  get() = noImpl; set(value) = noImpl
        var layers: Array<Any>?  get() = noImpl; set(value) = noImpl
        var target: Any?  get() = noImpl; set(value) = noImpl
        var view: ol.View?  get() = noImpl; set(value) = noImpl
    }
    interface OverlayOptions {
        var element: Element?  get() = noImpl; set(value) = noImpl
        var positioning: ol.OverlayPositioning?  get() = noImpl; set(value) = noImpl
    }
    interface ViewOptions {
        var zoom: Number?  get() = noImpl; set(value) = noImpl
    }
    interface Projection {
    }
    @native
    object control {
        interface DefaultsOptions {
            var attributionOptions: Any?  get() = noImpl; set(value) = noImpl
        }
    }
    @native
    object layer {
        interface BaseOptions {
        }
        interface ImageOptions : LayerOptions
        interface LayerOptions : BaseOptions {
            var source: ol.source.Source?  get() = noImpl; set(value) = noImpl
        }
        interface TileOptions : LayerOptions {
            override var source: ol.source.Source?  get() = noImpl; set(value) = noImpl
        }
        interface VectorOptions : LayerOptions {
            override var source: ol.source.Source?  get() = noImpl; set(value) = noImpl
            var style: dynamic /* ol.style.Style | Array<ol.style.Style> | Any */?  get() = noImpl; set(value) = noImpl

            var map: dynamic get() = noImpl; set(value) = noImpl
        }
    }
    @native
    object source {
        interface VectorOptions {
            var features: dynamic /* Array<ol.Feature> | ol.Collection<ol.Feature> */?  get() = noImpl; set(value) = noImpl
            var loader: ol.FeatureLoader?  get() = noImpl; set(value) = noImpl
        }
    }
    @native
    object style {
        interface StyleOptions {
            var image: ol.style.Image?  get() = noImpl; set(value) = noImpl
        }
        interface IconOptions {
            var scale: Number?  get() = noImpl; set(value) = noImpl
            var src: String?  get() = noImpl; set(value) = noImpl
        }
    }
}

@native
object ol {
    open class Collection<T>(values: Array<T>) : ol.Object() {
    }
    open class Feature(geometryOrProperties: dynamic /* ol.geom.Geometry | Any */? = null) : ol.Object() {
        open fun setGeometry(geometry: ol.geom.Geometry?): Unit = noImpl
        open fun setStyle(style: ol.style.Style): Unit = noImpl
    }

    open class Geolocation(options: olx.GeolocationOptions? = null) : ol.Object() {
        open fun getPosition(): ol.Coordinate = noImpl
        open fun setTracking(tracking: Boolean): Unit = noImpl
    }
    open class Image : ol.ImageBase() {
    }
    open class ImageBase
    open class Map(options: olx.MapOptions) : ol.Object() {
        open fun addLayer(layer: ol.layer.Base): Unit = noImpl
        open fun addOverlay(overlay: ol.Overlay): Unit = noImpl
        open fun <T> forEachFeatureAtPixel(pixel: ol.Pixel, callback: (feature: ol.Feature, layer: ol.layer.Layer) -> T, ref: Any? = null, layerFilter: ((layerCandidate: ol.layer.Layer) -> Boolean)? = null, ref2: Any? = null): T? = noImpl
    }
    open class MapBrowserEvent : MapEvent() {
        open var coordinate: Coordinate = noImpl
        open var originalEvent: Event = noImpl
        open var pixel: Pixel = noImpl
    }
    open class MapEvent {
    }
    open class Object(values: Object? = null) : Observable() {
        open fun get(key: String): Any = noImpl
    }
    open class Observable {
        open fun on(type: String, listener: (event: MapBrowserEvent) -> Unit, ref: Any? = null): Any = noImpl
    }
    open class Overlay(options: olx.OverlayOptions) : ol.Object() {
        open fun setPosition(position: ol.Coordinate = noImpl): Unit = noImpl
    }
    open class Tile {
    }
    open class View(options: olx.ViewOptions? = null) : ol.Object() {
        open fun getProjection(): ol.proj.Projection = noImpl
        open fun setCenter(center: ol.Coordinate): Unit = noImpl
    }
    @native
    object control {
        fun defaults(options: olx.control.DefaultsOptions? = null): ol.Collection<ol.control.Control> = noImpl
        open class Control
    }
    @native
    object geom {
        interface GeometryLayout /*: String*/
        open class Geometry : ol.Object() {
        }
        open class Point(coordinates: ol.Coordinate, layout: ol.geom.GeometryLayout? = null) : SimpleGeometry() {
        }
        open class SimpleGeometry : ol.geom.Geometry() {
        }
    }

    @native
    object layer {
        open class Base(options: olx.layer.BaseOptions? = null) : ol.Object() {
        }
        open class Image(options: olx.layer.ImageOptions? = null) : ol.layer.Layer() {
        }
        open class Layer(options: olx.layer.LayerOptions? = null) : ol.layer.Base() {
        }
        open class Tile(options: olx.layer.TileOptions? = null) : ol.layer.Layer() {
        }
        open class Vector(options: olx.layer.VectorOptions? = null) : ol.layer.Layer() {
        }
    }
    @native
    object proj {
        open class Projection(options: olx.Projection) {
        }
    }
    @native
    object source {
        open class Image
        open class MapQuest(options: Any) : Source()
        open class Source
        open class Tile : Source()
        open class Vector(opts: olx.source.VectorOptions? = null) : Source() {
            open fun addFeature(feature: ol.Feature): Unit = noImpl
        }
    }
    @native
    object style {
        open class Icon(option: olx.style.IconOptions) : Image()
        open class Image {
        }
        open class Style(opts: olx.style.StyleOptions) {
        }
    }
    interface Coordinate/* : Array<Number>*/ {
        @nativeGetter
        operator fun get(i: Int): Number?
    }
    interface Extent /*: Array<Number>*/{
        @nativeGetter
        operator fun get(i: Int): Number?
    }
    interface OverlayPositioning /*: String*/
    fun OverlayPositioning(s: String)

    interface Pixel/* : Array<Number>*/{
        @nativeGetter
        operator fun get(i: Int): Number?
    }
    interface FeatureLoader {
        @nativeInvoke
        fun invoke(extent: ol.Extent, number: Number, projection: ol.proj.Projection): String
    }
}
