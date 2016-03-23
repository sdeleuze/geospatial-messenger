package openlayers

import org.w3c.dom.Element
import org.w3c.dom.events.Event

//import org.khronos.webgl.WebGLFramebuffer
//import org.khronos.webgl.WebGLProgram
//import org.khronos.webgl.WebGLRenderingContext
//import org.w3c.dom.Element
//import org.w3c.dom.HTMLCanvasElement
//import org.w3c.dom.HTMLImageElement
//import org.w3c.dom.HTMLVideoElement
//
@native
object olx {
//    interface AttributionOptions {
//        var html: String
//    }
//    interface DeviceOrientationOptions {
//        var tracking: Boolean?  get() = noImpl; set(value) = noImpl
//    }
//    interface FrameState {
//        var pixelRatio: Number
//        var time: Number
//        var viewState: olx.ViewState
//    }
//    interface FeatureOverlayOptions {
//        var features: dynamic /* Array<ol.Feature> | ol.Collection<ol.Feature> | ol.style.StyleFunction */?  get() = noImpl; set(value) = noImpl
//        var map: ol.Map
//        var style: dynamic /* ol.style.Style | Array<ol.style.Style> */
//    }
    interface GeolocationOptions {
//        var tracking: Boolean? get() = noImpl; set(value) = noImpl
//        var trackingOptions: PositionOptions?  get() = noImpl; set(value) = noImpl
        var projection: dynamic /* ol.proj.ProjectionLike | ol.proj.Projection */?  get() = noImpl; set(value) = noImpl
    }
//    interface GraticuleOptions {
//        var map: ol.Map?  get() = noImpl; set(value) = noImpl
//        var maxLines: Number?  get() = noImpl; set(value) = noImpl
//        var strokeStyle: ol.style.Stroke?  get() = noImpl; set(value) = noImpl
//        var targetSize: Number?  get() = noImpl; set(value) = noImpl
//    }
//    interface BaseWMSOptions {
//        var attributions: Array<ol.Attribution>?  get() = noImpl; set(value) = noImpl
//        var params: Any?  get() = noImpl; set(value) = noImpl
//        var crossOrigin: String?  get() = noImpl; set(value) = noImpl
//        var hidpi: Boolean?  get() = noImpl; set(value) = noImpl
//        var serverType: ol.source.wms.ServerType?  get() = noImpl; set(value) = noImpl
//        var url: String?  get() = noImpl; set(value) = noImpl
//        var logo: olx.LogoOptions?  get() = noImpl; set(value) = noImpl
//        var projection: ol.proj.ProjectionLike?  get() = noImpl; set(value) = noImpl
//    }
//    interface ImageWMSOptions : BaseWMSOptions {
//        var imageLoadFunction: ol.ImageLoadFunctionType?  get() = noImpl; set(value) = noImpl
//        var ratio: Number?  get() = noImpl; set(value) = noImpl
//        var resolutions: Array<Number>?  get() = noImpl; set(value) = noImpl
//    }
//    interface TileWMSOptions {
//        var attributions: Array<ol.Attribution>?  get() = noImpl; set(value) = noImpl
//        var params: Object
//        var crossOrigin: String?  get() = noImpl; set(value) = noImpl
//        var gutter: Number?  get() = noImpl; set(value) = noImpl
//        var hidpi: Boolean?  get() = noImpl; set(value) = noImpl
//        var logo: dynamic /* String | olx.LogoOptions */?  get() = noImpl; set(value) = noImpl
//        var tileGrid: ol.tilegrid.TileGrid?  get() = noImpl; set(value) = noImpl
//        var maxZoom: Number?  get() = noImpl; set(value) = noImpl
//        var projection: ol.proj.ProjectionLike?  get() = noImpl; set(value) = noImpl
//        var reprojectionErrorThreshold: Number?  get() = noImpl; set(value) = noImpl
//        var tileLoadFunction: ol.TileLoadFunctionType?  get() = noImpl; set(value) = noImpl
//        var url: String?  get() = noImpl; set(value) = noImpl
//        var urls: Array<String>?  get() = noImpl; set(value) = noImpl
//        var serverType: ol.source.wms.ServerType?  get() = noImpl; set(value) = noImpl
//        var wrapX: Boolean?  get() = noImpl; set(value) = noImpl
//    }
//    interface LogoOptions {
//        var href: String
//        var src: String
//    }
    interface MapOptions {
        var controls: Any?  get() = noImpl; set(value) = noImpl
//        var pixelRatio: Number?  get() = noImpl; set(value) = noImpl
//        var interactions: Any?  get() = noImpl; set(value) = noImpl
//        var keyboardEventTarget: Any?  get() = noImpl; set(value) = noImpl
        var layers: Array<Any>?  get() = noImpl; set(value) = noImpl
//        var loadTilesWhileAnimating: Boolean?  get() = noImpl; set(value) = noImpl
//        var loadTilesWhileInteracting: Boolean?  get() = noImpl; set(value) = noImpl
//        var logo: Any?  get() = noImpl; set(value) = noImpl
//        var overlays: Any?  get() = noImpl; set(value) = noImpl
//        var renderer: Any?  get() = noImpl; set(value) = noImpl
        var target: Any?  get() = noImpl; set(value) = noImpl
        var view: ol.View?  get() = noImpl; set(value) = noImpl
    }
    interface OverlayOptions {
        var element: Element?  get() = noImpl; set(value) = noImpl
//        var offset: Array<Number>?  get() = noImpl; set(value) = noImpl
//        var position: ol.Coordinate?  get() = noImpl; set(value) = noImpl
        var positioning: ol.OverlayPositioning?  get() = noImpl; set(value) = noImpl
//        var stopEvent: Boolean?  get() = noImpl; set(value) = noImpl
//        var insertFirst: Boolean?  get() = noImpl; set(value) = noImpl
//        var autoPan: Boolean?  get() = noImpl; set(value) = noImpl
//        var autoPanAnimation: olx.animation.PanOptions?  get() = noImpl; set(value) = noImpl
//        var autoPanMargin: Number?  get() = noImpl; set(value) = noImpl
    }
    interface ViewOptions {
//        var center: ol.Coordinate?  get() = noImpl; set(value) = noImpl
//        var constrainRotation: Boolean?  get() = noImpl; set(value) = noImpl
//        var enableRotation: Boolean?  get() = noImpl; set(value) = noImpl
//        var extent: ol.Extent?  get() = noImpl; set(value) = noImpl
//        var maxResolution: Number?  get() = noImpl; set(value) = noImpl
//        var minResolution: Number?  get() = noImpl; set(value) = noImpl
//        var maxZoom: Number?  get() = noImpl; set(value) = noImpl
//        var minZoom: Number?  get() = noImpl; set(value) = noImpl
//        var projection: dynamic /* ol.proj.ProjectionLike | ol.proj.Projection */?  get() = noImpl; set(value) = noImpl
//        var resolution: Number?  get() = noImpl; set(value) = noImpl
//        var resolutions: Array<Number>?  get() = noImpl; set(value) = noImpl
//        var rotation: Number?  get() = noImpl; set(value) = noImpl
        var zoom: Number?  get() = noImpl; set(value) = noImpl
//        var zoomFactor: Number?  get() = noImpl; set(value) = noImpl
    }
//    interface ViewState {
//        var center: ol.Coordinate
//        var projection: ol.proj.Projection
//        var resolution: Number
//        var rotation: Number
//    }
    interface Projection {
//        var code: String
//        var units: ol.proj.Units?  get() = noImpl; set(value) = noImpl
//        var extent: Array<Number>?  get() = noImpl; set(value) = noImpl
//        var axisOrientation: String?  get() = noImpl; set(value) = noImpl
//        var global: Boolean?  get() = noImpl; set(value) = noImpl
//        var worldExtent: ol.Extent?  get() = noImpl; set(value) = noImpl
//        var getPointResolution: ((resolution: Number, coordinate: ol.Coordinate) -> Number)?  get() = noImpl; set(value) = noImpl
    }
//    @native
//    object animation {
//        interface BounceOptions {
//            var resolution: Number
//            var start: Number?  get() = noImpl; set(value) = noImpl
//            var duration: Number?  get() = noImpl; set(value) = noImpl
//            var easing: ((t: Number) -> Number)?  get() = noImpl; set(value) = noImpl
//        }
//        interface PanOptions {
//            var source: ol.Coordinate
//            var start: Number?  get() = noImpl; set(value) = noImpl
//            var duration: Number?  get() = noImpl; set(value) = noImpl
//            var easing: ((t: Number) -> Number)?  get() = noImpl; set(value) = noImpl
//        }
//        interface RotateOptions {
//            var rotation: Number?  get() = noImpl; set(value) = noImpl
//            var anchor: ol.Coordinate?  get() = noImpl; set(value) = noImpl
//            var start: Number?  get() = noImpl; set(value) = noImpl
//            var duration: Number?  get() = noImpl; set(value) = noImpl
//            var easing: ((t: Number) -> Number)?  get() = noImpl; set(value) = noImpl
//        }
//        interface ZoomOptions {
//            var resolution: Number
//            var start: Number?  get() = noImpl; set(value) = noImpl
//            var duration: Number?  get() = noImpl; set(value) = noImpl
//            var easing: ((t: Number) -> Number)?  get() = noImpl; set(value) = noImpl
//        }
//    }
    @native
    object control {
        interface DefaultsOptions {
//            var attribution: Boolean?  get() = noImpl; set(value) = noImpl
            var attributionOptions: Any?  get() = noImpl; set(value) = noImpl
//            var rotate: Boolean?  get() = noImpl; set(value) = noImpl
//            var rotateOptions: Any?  get() = noImpl; set(value) = noImpl
//            var zoom: Boolean?  get() = noImpl; set(value) = noImpl
//            var zoomOptions: Any?  get() = noImpl; set(value) = noImpl
        }
    }
//    @native
//    object interaction {
//        interface DefaultsOptions {
//            var altShiftDragRotate: Boolean?  get() = noImpl; set(value) = noImpl
//            var doubleClickZoom: Boolean?  get() = noImpl; set(value) = noImpl
//            var keyboard: Boolean?  get() = noImpl; set(value) = noImpl
//            var mouseWheelZoom: Boolean?  get() = noImpl; set(value) = noImpl
//            var shiftDragZoom: Boolean?  get() = noImpl; set(value) = noImpl
//            var dragPan: Boolean?  get() = noImpl; set(value) = noImpl
//            var pinchRotate: Boolean?  get() = noImpl; set(value) = noImpl
//            var pinchZoom: Boolean?  get() = noImpl; set(value) = noImpl
//            var zoomDelta: Number?  get() = noImpl; set(value) = noImpl
//            var zoomDuration: Number?  get() = noImpl; set(value) = noImpl
//        }
//        interface ModifyOptions {
//            var deleteCondition: ol.events.ConditionType?  get() = noImpl; set(value) = noImpl
//            var pixelTolerance: Number?  get() = noImpl; set(value) = noImpl
//            var style: dynamic /* ol.style.Style | Array<ol.style.Style> | ol.style.StyleFunction */?  get() = noImpl; set(value) = noImpl
//            var features: ol.Collection<ol.Feature>
//            var wrapX: Boolean?  get() = noImpl; set(value) = noImpl
//        }
//        interface DrawOptions {
//            var clickTolerance: Number?  get() = noImpl; set(value) = noImpl
//            var features: ol.Collection<ol.Feature>?  get() = noImpl; set(value) = noImpl
//            var source: ol.source.Vector?  get() = noImpl; set(value) = noImpl
//            var snapTolerance: Number?  get() = noImpl; set(value) = noImpl
//            var type: ol.geom.GeometryType
//            var maxPoints: Number?  get() = noImpl; set(value) = noImpl
//            var minPoints: Number?  get() = noImpl; set(value) = noImpl
//            var style: dynamic /* ol.style.Style | Array<ol.style.Style> | ol.style.StyleFunction */?  get() = noImpl; set(value) = noImpl
//            var geometryFunction: ol.interaction.DrawGeometryFunctionType?  get() = noImpl; set(value) = noImpl
//            var wrapX: Boolean?  get() = noImpl; set(value) = noImpl
//        }
//        interface SelectOptions {
//            var addCondition: ol.events.ConditionType?  get() = noImpl; set(value) = noImpl
//            var condition: ol.events.ConditionType?  get() = noImpl; set(value) = noImpl
//            var layers: Array<ol.layer.Layer>?  get() = noImpl; set(value) = noImpl
//            var style: dynamic /* ol.style.Style | Array<ol.style.Style> | ol.style.StyleFunction */?  get() = noImpl; set(value) = noImpl
//            var removeCondition: ol.events.ConditionType?  get() = noImpl; set(value) = noImpl
//            var toggleCondition: ol.events.ConditionType?  get() = noImpl; set(value) = noImpl
//            var multi: Boolean?  get() = noImpl; set(value) = noImpl
//            var features: ol.Collection<ol.Feature>?  get() = noImpl; set(value) = noImpl
//            var filter: ol.interaction.SelectFilterFunction?  get() = noImpl; set(value) = noImpl
//            var wrapX: Boolean?  get() = noImpl; set(value) = noImpl
//        }
//    }
    @native
    object layer {
        interface BaseOptions {
//            var opacity: Number?  get() = noImpl; set(value) = noImpl
//            var visible: Boolean?  get() = noImpl; set(value) = noImpl
//            var extent: ol.Extent?  get() = noImpl; set(value) = noImpl
//            var zIndex: Number?  get() = noImpl; set(value) = noImpl
//            var minResolution: Number?  get() = noImpl; set(value) = noImpl
//            var maxResolution: Number?  get() = noImpl; set(value) = noImpl
        }
//        interface GroupOptions : BaseOptions {
//            var layers: dynamic /* Array<ol.layer.Base> | ol.Collection<ol.layer.Base> */?  get() = noImpl; set(value) = noImpl
//        }
//        interface HeatmapOptions : VectorOptions {
//            var gradient: Array<String>?  get() = noImpl; set(value) = noImpl
//            var radius: Number?  get() = noImpl; set(value) = noImpl
//            var blur: Number?  get() = noImpl; set(value) = noImpl
//            var shadow: Number?  get() = noImpl; set(value) = noImpl
//        }
        interface ImageOptions : LayerOptions
        interface LayerOptions : BaseOptions {
            var source: ol.source.Source?  get() = noImpl; set(value) = noImpl
        }
        interface TileOptions : LayerOptions {
//            var preload: Number?  get() = noImpl; set(value) = noImpl
            override var source: ol.source.Source?  get() = noImpl; set(value) = noImpl
//            var useInterimTilesOnError: Boolean?  get() = noImpl; set(value) = noImpl
        }
        interface VectorOptions : LayerOptions {
//            var updateWhileAnimating: Boolean?  get() = noImpl; set(value) = noImpl
//            var updateWhileInteracting: Boolean?  get() = noImpl; set(value) = noImpl
//            var renderOrder: Any?  get() = noImpl; set(value) = noImpl
//            var renderBuffer: Number?  get() = noImpl; set(value) = noImpl
            override var source: ol.source.Source?  get() = noImpl; set(value) = noImpl
            var style: dynamic /* ol.style.Style | Array<ol.style.Style> | Any */?  get() = noImpl; set(value) = noImpl

            var map: dynamic get() = noImpl; set(value) = noImpl
        }
    }
    @native
    object source {
        interface VectorOptions {
//            var attributions: Array<ol.Attribution>?  get() = noImpl; set(value) = noImpl
            var features: dynamic /* Array<ol.Feature> | ol.Collection<ol.Feature> */?  get() = noImpl; set(value) = noImpl
//            var format: ol.format.Feature?  get() = noImpl; set(value) = noImpl
            var loader: ol.FeatureLoader?  get() = noImpl; set(value) = noImpl
//            var logo: dynamic /* String | olx.LogoOptions */?  get() = noImpl; set(value) = noImpl
//            var strategy: ol.LoadingStrategy?  get() = noImpl; set(value) = noImpl
//            var url: String?  get() = noImpl; set(value) = noImpl
//            var useSpatialIndex: Boolean?  get() = noImpl; set(value) = noImpl
//            var wrapX: Boolean?  get() = noImpl; set(value) = noImpl
        }
//        interface WMTSOptions {
//            var attributions: Array<ol.Attribution>?  get() = noImpl; set(value) = noImpl
//            var crossOrigin: String?  get() = noImpl; set(value) = noImpl
//            var logo: dynamic /* String | olx.LogoOptions */?  get() = noImpl; set(value) = noImpl
//            var tileGrid: ol.tilegrid.WMTS
//            var projection: ol.proj.ProjectionLike?  get() = noImpl; set(value) = noImpl
//            var reprojectionErrorThreshold: Number?  get() = noImpl; set(value) = noImpl
//            var requestEncoding: ol.source.WMTSRequestEncoding?  get() = noImpl; set(value) = noImpl
//            var layer: String
//            var style: String
//            var tileClass: Function?  get() = noImpl; set(value) = noImpl
//            var tilePixelRatio: Number?  get() = noImpl; set(value) = noImpl
//            var version: String?  get() = noImpl; set(value) = noImpl
//            var format: String?  get() = noImpl; set(value) = noImpl
//            var matrixSet: String
//            var dimensions: Object?  get() = noImpl; set(value) = noImpl
//            var url: String?  get() = noImpl; set(value) = noImpl
//            var maxZoom: Number?  get() = noImpl; set(value) = noImpl
//            var tileLoadFunction: ol.TileLoadFunctionType?  get() = noImpl; set(value) = noImpl
//            var urls: Array<String>?  get() = noImpl; set(value) = noImpl
//            var wrapX: Boolean
//        }
    }
    @native
    object style {
//        interface FillOptions {
//            var color: dynamic /* ol.Color | String */?  get() = noImpl; set(value) = noImpl
//        }
        interface StyleOptions {
//            var geometry: dynamic /* String | ol.geom.Geometry | ol.style.GeometryFunction */?  get() = noImpl; set(value) = noImpl
//            var fill: ol.style.Fill?  get() = noImpl; set(value) = noImpl
            var image: ol.style.Image?  get() = noImpl; set(value) = noImpl
//            var stroke: ol.style.Stroke?  get() = noImpl; set(value) = noImpl
//            var text: ol.style.Text?  get() = noImpl; set(value) = noImpl
//            var zIndex: Number?  get() = noImpl; set(value) = noImpl
        }
//        interface TextOptions {
//            var font: String?  get() = noImpl; set(value) = noImpl
//            var offsetX: Number?  get() = noImpl; set(value) = noImpl
//            var offsetY: Number?  get() = noImpl; set(value) = noImpl
//            var scale: Number?  get() = noImpl; set(value) = noImpl
//            var rotation: Number?  get() = noImpl; set(value) = noImpl
//            var text: String?  get() = noImpl; set(value) = noImpl
//            var textAlign: String?  get() = noImpl; set(value) = noImpl
//            var textBaseline: String?  get() = noImpl; set(value) = noImpl
//            var fill: ol.style.Fill?  get() = noImpl; set(value) = noImpl
//            var stroke: ol.style.Stroke?  get() = noImpl; set(value) = noImpl
//        }
//        interface StrokeOptions {
//            var color: dynamic /* ol.Color | String */?  get() = noImpl; set(value) = noImpl
//            var lineCap: String?  get() = noImpl; set(value) = noImpl
//            var lineJoin: String?  get() = noImpl; set(value) = noImpl
//            var lineDash: Array<Number>?  get() = noImpl; set(value) = noImpl
//            var miterLimit: Number?  get() = noImpl; set(value) = noImpl
//            var width: Number?  get() = noImpl; set(value) = noImpl
//        }
        interface IconOptions {
//            var anchor: Array<Number>?  get() = noImpl; set(value) = noImpl
//            var anchorOrigin: String?  get() = noImpl; set(value) = noImpl
//            var anchorXUnits: String?  get() = noImpl; set(value) = noImpl
//            var anchorYUnits: String?  get() = noImpl; set(value) = noImpl
//            var crossOrigin: String?  get() = noImpl; set(value) = noImpl
//            var img: dynamic /* ol.Image | HTMLCanvasElement */?  get() = noImpl; set(value) = noImpl
//            var offset: Array<Number>?  get() = noImpl; set(value) = noImpl
//            var offsetOrigin: String?  get() = noImpl; set(value) = noImpl
//            var opacity: Number?  get() = noImpl; set(value) = noImpl
            var scale: Number?  get() = noImpl; set(value) = noImpl
//            var snapToPixel: Boolean?  get() = noImpl; set(value) = noImpl
//            var rotateWithView: Boolean?  get() = noImpl; set(value) = noImpl
//            var rotation: Number?  get() = noImpl; set(value) = noImpl
//            var size: ol.Size?  get() = noImpl; set(value) = noImpl
//            var imgSize: ol.Size?  get() = noImpl; set(value) = noImpl
            var src: String?  get() = noImpl; set(value) = noImpl
        }
//        interface CircleOptions {
//            var fill: ol.style.Fill?  get() = noImpl; set(value) = noImpl
//            var radius: Number
//            var snapToPixel: Boolean?  get() = noImpl; set(value) = noImpl
//            var stroke: ol.style.Stroke?  get() = noImpl; set(value) = noImpl
//        }
    }
//    @native
//    object tilegrid {
//        interface TileGridOptions {
//            var extent: ol.Extent?  get() = noImpl; set(value) = noImpl
//            var minZoom: Number?  get() = noImpl; set(value) = noImpl
//            var origin: ol.Coordinate?  get() = noImpl; set(value) = noImpl
//            var origins: Array<ol.Coordinate>?  get() = noImpl; set(value) = noImpl
//            var resolutions: Array<Number>?  get() = noImpl; set(value) = noImpl
//            var tileSize: dynamic /* Number | ol.Size */?  get() = noImpl; set(value) = noImpl
//            var tileSizes: Array<dynamic /* Number | ol.Size */>?  get() = noImpl; set(value) = noImpl
//        }
//        interface WMTSOptions {
//            var extent: ol.Extent?  get() = noImpl; set(value) = noImpl
//            var origin: ol.Coordinate?  get() = noImpl; set(value) = noImpl
//            var origins: Array<ol.Coordinate>?  get() = noImpl; set(value) = noImpl
//            var resolutions: Array<Number>?  get() = noImpl; set(value) = noImpl
//            var matrixIds: Array<String>?  get() = noImpl; set(value) = noImpl
//            var sizes: Array<ol.Size>?  get() = noImpl; set(value) = noImpl
//            var tileSize: dynamic /* Number | ol.Size */?  get() = noImpl; set(value) = noImpl
//            var tileSizes: Array<dynamic /* Number | ol.Size */>?  get() = noImpl; set(value) = noImpl
//            var widths: Array<Number>?  get() = noImpl; set(value) = noImpl
//        }
//        interface XYZOptions {
//            var extent: ol.Extent?  get() = noImpl; set(value) = noImpl
//            var maxZoom: Number?  get() = noImpl; set(value) = noImpl
//            var minZoom: Number?  get() = noImpl; set(value) = noImpl
//            var tileSize: dynamic /* Number | ol.Size */?  get() = noImpl; set(value) = noImpl
//        }
//        interface ZoomifyOptions {
//            var resolutions: Array<Number>
//        }
//    }
//    @native
//    object view {
//        interface FitGeometryOptions {
//            var padding: Array<Number>?  get() = noImpl; set(value) = noImpl
//            var constrainResolution: Boolean?  get() = noImpl; set(value) = noImpl
//            var nearest: Boolean?  get() = noImpl; set(value) = noImpl
//            var minResolution: Number?  get() = noImpl; set(value) = noImpl
//            var maxZoom: Number?  get() = noImpl; set(value) = noImpl
//        }
//    }
//    @native
//    object format {
//        interface WKTOptions {
//            var splitCollection: Boolean?  get() = noImpl; set(value) = noImpl
//        }
//        interface GeoJSONOptions {
//            var defaultDataProjection: dynamic /* ol.proj.ProjectionLike | ol.proj.Projection */?  get() = noImpl; set(value) = noImpl
//            var geometryName: String?  get() = noImpl; set(value) = noImpl
//        }
//        interface ReadOptions {
//            var dataProjection: dynamic /* ol.proj.ProjectionLike | ol.proj.Projection */?  get() = noImpl; set(value) = noImpl
//            var featureProjection: dynamic /* ol.proj.ProjectionLike | ol.proj.Projection */?  get() = noImpl; set(value) = noImpl
//        }
//        interface WriteOptions {
//            var dataProjection: dynamic /* ol.proj.ProjectionLike | ol.proj.Projection */?  get() = noImpl; set(value) = noImpl
//            var featureProjection: dynamic /* ol.proj.ProjectionLike | ol.proj.Projection */?  get() = noImpl; set(value) = noImpl
//            var rightHanded: Boolean?  get() = noImpl; set(value) = noImpl
//        }
//    }
}

@native
object ol {
    //    interface TileLoadFunctionType {
//        @nativeInvoke
//        fun invoke(image: ol.Image, url: String)
//    }
//    interface ImageLoadFunctionType {
//        @nativeInvoke
//        fun invoke(image: ol.Image, url: String)
//    }
//    open class Attribution(options: olx.AttributionOptions) {
//        open fun getHTML(): String = noImpl
//    }
    open class Collection<T>(values: Array<T>) : ol.Object() {
//        open fun clear(): Unit = noImpl
//        open fun extend(arr: Array<T>): Collection<T> = noImpl
//        open fun forEach(f: (element: T, index: Number, array: Array<T>) -> Unit, ref: Any? = null): Unit = noImpl
//        open fun getArray(): Array<T> = noImpl
//        open fun getLength(): Number = noImpl
//        open fun insertAt(index: Number, elem: T): Unit = noImpl
//        open fun item(index: Number): T = noImpl
//        open fun pop(): T = noImpl
//        open fun push(elem: T): Number = noImpl
//        open fun remove(elem: T): T = noImpl
//        open fun removeAt(index: Number): T = noImpl
//        open fun setAt(index: Number, elem: T): Unit = noImpl
    }
//    open class CollectionEvent<T> {
//        open var element: T = noImpl
//    }
//    open class DeviceOrientation(options: olx.DeviceOrientationOptions? = null) : ol.Object() {
//        open fun getAlpha(): Number = noImpl
//        open fun getBeta(): Number = noImpl
//        open fun getGamma(): Number = noImpl
//        open fun getHeading(): Number = noImpl
//        open fun getTracking(): Boolean = noImpl
//        open fun setTracking(tracking: Boolean): Unit = noImpl
//    }
//    open class DragBoxEvent {
//        open var coordinate: ol.Coordinate = noImpl
//    }
    open class Feature(geometryOrProperties: dynamic /* ol.geom.Geometry | Any */? = null) : ol.Object() {
//        open fun clone(): Feature = noImpl
//        open fun getGeometry(): ol.geom.Geometry = noImpl
//        open fun getGeometryName(): String = noImpl
//        open fun getId(): dynamic /* String | Number */ = noImpl
//        open fun getStyle(): dynamic /* ol.style.Style | Array<ol.style.Style> | ol.FeatureStyleFunction */ = noImpl
//        open fun getStyleFunction(): ol.FeatureStyleFunction = noImpl
        open fun setGeometry(geometry: ol.geom.Geometry?): Unit = noImpl
//        open fun setGeometryName(name: String): Unit = noImpl
//        open fun setId(id: dynamic /* String | Number */): Unit = noImpl
        open fun setStyle(style: ol.style.Style): Unit = noImpl
//        open fun setStyle(style: Array<ol.style.Style>): Unit = noImpl
//        open fun setStyle(style: ol.FeatureStyleFunction): Unit = noImpl
    }

    //    open class FeatureOverlay(options: olx.FeatureOverlayOptions? = null) {
//        open fun addFeature(feature: ol.Feature): Unit = noImpl
//        open var getFeatures: ol.Collection<ol.Feature> = noImpl
//        open fun getMap(): ol.Map = noImpl
//        open fun getStyle(): dynamic /* ol.style.Style | Array<ol.style.Style> | ol.style.StyleFunction */ = noImpl
//        open fun getStyleFunction(): ol.style.StyleFunction = noImpl
//        open fun removeFeature(feature: ol.Feature): Unit = noImpl
//        open fun setFeatures(features: ol.Collection<ol.Feature>): Unit = noImpl
//        open fun setMap(map: ol.Map): Unit = noImpl
//        open fun setStyle(style: ol.style.Style): Unit = noImpl
//        open fun setStyle(style: Array<ol.style.Style>): Unit = noImpl
//        open fun setStyle(style: ol.style.StyleFunction): Unit = noImpl
//    }
    open class Geolocation(options: olx.GeolocationOptions? = null) : ol.Object() {
//        open fun getAccuracy(): Number = noImpl
//        open fun getAccuracyGeometry(): ol.geom.Geometry = noImpl
//        open fun getAltitude(): Number = noImpl
//        open fun getAltitudeAccuracy(): Number = noImpl
//        open fun getHeading(): Number = noImpl
        open fun getPosition(): ol.Coordinate = noImpl
//        open fun getProjection(): ol.proj.Projection = noImpl
//        open fun getSpeed(): Number = noImpl
//        open fun getTracking(): Boolean = noImpl
//        open fun getTrackingOptions(): PositionOptions = noImpl
//        open fun setProjection(projection: ol.proj.Projection): Unit = noImpl
        open fun setTracking(tracking: Boolean): Unit = noImpl
//        open fun setTrackingOptions(options: PositionOptions): Unit = noImpl
    }
//    open class Graticule(options: olx.GraticuleOptions? = null) {
//        open fun getMap(): Map = noImpl
//        open fun getMeridians(): Array<ol.geom.LineString> = noImpl
//        open fun getParallels(): Array<ol.geom.LineString> = noImpl
//        open fun setMap(map: Map): Unit = noImpl
//    }
    open class Image : ol.ImageBase() {
//        open fun getImage(context: HTMLCanvasElement): Image = noImpl
//        open fun getImage(context: HTMLImageElement): Image = noImpl
//        open fun getImage(context: HTMLVideoElement): Image = noImpl
    }
    open class ImageBase
//    open class ImageTile : ol.Tile() {
//        open fun getImage(context: HTMLCanvasElement): Image = noImpl
//        open fun getImage(context: HTMLImageElement): Image = noImpl
//        open fun getImage(context: HTMLVideoElement): Image = noImpl
//    }
//    open class Kinetic(decay: Number, minVelocity: Number, delay: Number)
    open class Map(options: olx.MapOptions) : ol.Object() {
//        open fun addControl(control: ol.control.Control): Unit = noImpl
//        open fun addInteraction(interaction: ol.interaction.Interaction): Unit = noImpl
        open fun addLayer(layer: ol.layer.Base): Unit = noImpl
        open fun addOverlay(overlay: ol.Overlay): Unit = noImpl
//        open fun beforeRender(var_args: ol.PreRenderFunction): Unit = noImpl
        open fun <T> forEachFeatureAtPixel(pixel: ol.Pixel, callback: (feature: ol.Feature, layer: ol.layer.Layer) -> T, ref: Any? = null, layerFilter: ((layerCandidate: ol.layer.Layer) -> Boolean)? = null, ref2: Any? = null): T? = noImpl
//        open fun forEachLayerAtPixel(pixel: ol.Pixel, callback: (layer: ol.layer.Layer) -> Any, ref: Any? = null, layerFilter: ((layerCandidate: ol.layer.Layer) -> Boolean)? = null, ref2: Any? = null): Unit = noImpl
//        open fun getControls(): ol.Collection<ol.control.Control> = noImpl
//        open fun getCoordinateFromPixel(pixel: ol.Pixel): ol.Coordinate = noImpl
//        open fun getEventCoordinate(event: Event): ol.Coordinate = noImpl
//        open fun getEventPixel(event: Event): ol.Pixel = noImpl
//        open fun getInteractions(): ol.Collection<ol.interaction.Interaction> = noImpl
//        open fun getLayerGroup(): ol.layer.Group = noImpl
//        open fun getLayers(): ol.Collection<ol.layer.Base> = noImpl
//        open fun getOverlays(): ol.Collection<ol.Overlay> = noImpl
//        open fun getPixelFromCoordinate(coordinate: ol.Coordinate): ol.Pixel = noImpl
//        open fun getSize(): ol.Size = noImpl
//        open fun getTarget(): dynamic /* Element | String */ = noImpl
//        open fun getTargetElement(): Element = noImpl
//        open fun getView(): View = noImpl
//        open fun getViewport(): Element = noImpl
//        open fun hasFeatureAtPixel(pixel: ol.Pixel, layerFilter: ((layer: ol.layer.Layer) -> Boolean)? = null, ref: Any? = null): Boolean = noImpl
//        open fun removeControl(control: ol.control.Control): ol.control.Control = noImpl
//        open fun removeInteraction(interaction: ol.interaction.Interaction): ol.interaction.Interaction = noImpl
//        open fun removeLayer(layer: ol.layer.Base): ol.layer.Base = noImpl
//        open fun removeOverlay(overlay: ol.Overlay): ol.Overlay = noImpl
//        open fun render(): Unit = noImpl
//        open fun renderSync(): Unit = noImpl
//        open fun setLayerGroup(layerGroup: ol.layer.Group): Unit = noImpl
//        open fun setSize(size: ol.Size): Unit = noImpl
//        open fun setTarget(target: Element): Unit = noImpl
//        open fun setTarget(target: String): Unit = noImpl
//        open fun setView(view: View): Unit = noImpl
//        open fun updateSize(): Unit = noImpl
    }
    open class MapBrowserEvent : MapEvent() {
        open var coordinate: Coordinate = noImpl
//        open var dragging: Boolean = noImpl
//        override var frameState: olx.FrameState = noImpl
//        override var map: Map = noImpl
        open var originalEvent: Event = noImpl
        open var pixel: Pixel = noImpl
//        open fun preventDefault(): Unit = noImpl
//        open fun stopPropagation(): Unit = noImpl
    }
    open class MapEvent {
//        open var frameState: olx.FrameState = noImpl
//        open var map: Map = noImpl
    }
    open class Object(values: Object? = null) : Observable() {
        open fun get(key: String): Any = noImpl
//        open fun getKeys(): Array<String> = noImpl
//        open fun getProperties(): Object = noImpl
//        override fun getRevision(): Number = noImpl
//        open fun set(key: String, value: Any): Unit = noImpl
//        open fun setProperties(values: Object): Unit = noImpl
//        open fun unset(key: String): Unit = noImpl
    }

    //    open class ObjectEvent {
//        open var key: String = noImpl
//        open var oldValue: Any = noImpl
//    }
    open class Observable {
//        open fun unByKey(key: Any): Unit = noImpl
//        open fun changed(): Unit = noImpl
//        open fun getRevision(): Number = noImpl
        open fun on(type: String, listener: (event: MapBrowserEvent) -> Unit, ref: Any? = null): Any = noImpl
//        open fun on(type: Array<String>, listener: (event: MapBrowserEvent) -> Unit, ref: Any? = null): Any = noImpl
//        open fun once(type: String, listener: (event: MapBrowserEvent) -> Unit, ref: Any? = null): Any = noImpl
//        open fun once(type: Array<String>, listener: (event: MapBrowserEvent) -> Unit, ref: Any? = null): Any = noImpl
//        open fun un(type: Array<String>, listener: (event: MapBrowserEvent) -> Unit, ref: Any? = null): Any = noImpl
////        open fun unByKey(key: Any): Unit = noImpl
    }
    open class Overlay(options: olx.OverlayOptions) : ol.Object() {
//        open fun getElement(): Element = noImpl
//        open fun getMap(): ol.Map = noImpl
//        open fun getOffset(): Array<Number> = noImpl
//        open fun getPosition(): ol.Coordinate = noImpl
//        open fun getPositioning(): ol.OverlayPositioning = noImpl
//        open fun setElement(element: Element): Unit = noImpl
//        open fun setMap(map: Map): Unit = noImpl
//        open fun setOffset(offset: Array<Number>): Unit = noImpl
        open fun setPosition(position: ol.Coordinate = noImpl): Unit = noImpl
//        open fun setPositioning(positioning: ol.OverlayPositioning): Unit = noImpl
    }
//    open class SelectEvent {
//        open var deselected: Array<ol.Feature> = noImpl
//        open var mapBrowserEvent: ol.MapBrowserEvent = noImpl
//        open var selected: Array<ol.Feature> = noImpl
//    }
//    open class Sphere(radius: Number) {
//        open fun geodesicArea(coordinates: Array<ol.Coordinate>): Number = noImpl
//        open fun haversineDistance(c1: ol.Coordinate, c2: ol.Coordinate): Number = noImpl
//    }
    open class Tile {
//        open fun getTileCoord(): ol.TileCoord = noImpl
    }
    open class View(options: olx.ViewOptions? = null) : ol.Object() {
//        open fun calculateExtent(size: ol.Size): ol.Extent = noImpl
//        open fun centerOn(coordinate: ol.Coordinate, size: ol.Size, position: ol.Pixel): Unit = noImpl
//        open fun constrainCenter(center: ol.Coordinate): ol.Coordinate = noImpl
//        open fun constrainResolution(resolution: Number, delta: Number? = null, direction: Number? = null): Number = noImpl
//        open fun fit(geometry: dynamic /* ol.geom.SimpleGeometry | ol.Extent */, size: ol.Size, opt_options: olx.view.FitGeometryOptions? = null): Unit = noImpl
//        open fun getCenter(): ol.Coordinate = noImpl
        open fun getProjection(): ol.proj.Projection = noImpl
//        open fun getResolution(): Number = noImpl
//        open fun getRotation(): Number = noImpl
//        open fun getZoom(): Number = noImpl
//        open fun rotate(rotation: Number, anchor: ol.Coordinate): Unit = noImpl
        open fun setCenter(center: ol.Coordinate): Unit = noImpl
//        open fun setResolution(resolution: Number): Unit = noImpl
//        open fun setRotation(rotation: Number): Unit = noImpl
//        open fun setZoom(zoom: Number): Unit = noImpl
    }
//    @native
//    object animation {
//        fun bounce(options: olx.animation.BounceOptions): ol.PreRenderFunction = noImpl
//        fun pan(options: olx.animation.PanOptions): ol.PreRenderFunction = noImpl
//        fun rotate(options: olx.animation.RotateOptions): ol.PreRenderFunction = noImpl
//        fun zoom(options: olx.animation.ZoomOptions): ol.PreRenderFunction = noImpl
//    }
//    @native
//    object color {
//        fun asArray(color: ol.Color): ol.Color = noImpl
//        fun asArray(color: String): ol.Color = noImpl
//        fun asString(color: ol.Color): String = noImpl
//        fun asString(color: String): String = noImpl
//    }
    @native
    object control {
        fun defaults(options: olx.control.DefaultsOptions? = null): ol.Collection<ol.control.Control> = noImpl
//        interface ScaleLineUnits : String
//        open class Attribution
        open class Control
//        open class FullScreen
//        open class MousePosition
//        open class OverviewMap
//        open class Rotate
//        open class ScaleLine
//        open class Zoom
//        open class ZoomSlider
//        open class ZoomToExtent
    }
//    @native
//    object coordinate {
//        fun add(coordinate: ol.Coordinate, delta: ol.Coordinate): ol.Coordinate = noImpl
//        fun createStringXY(fractionDigits: Number? = null): ol.CoordinateFormatType = noImpl
//        fun format(coordinate: ol.Coordinate, template: String, fractionDigits: Number? = null): String = noImpl
//        fun rotate(coordinate: ol.Coordinate, angle: Number): ol.Coordinate = noImpl
//        fun toStringHDMS(coordinate: ol.Coordinate? = null): String = noImpl
//        fun toStringXY(coordinate: ol.Coordinate? = null, fractionDigits: Number? = null): String = noImpl
//    }
//    @native
//    object easing {
//        fun easeIn(t: Number): Number = noImpl
//        fun easeOut(t: Number): Number = noImpl
//        fun inAndOut(t: Number): Number = noImpl
//        fun linear(t: Number): Number = noImpl
//        fun upAndDown(t: Number): Number = noImpl
//    }
//    @native
//    object events {
//        @native
//        object condition {
//            fun altKeyOnly(mapBrowserEvent: ol.MapBrowserEvent): Boolean = noImpl
//            fun altShiftKeyOnly(mapBrowserEvent: ol.MapBrowserEvent): Boolean = noImpl
//            fun always(mapBrowserEvent: ol.MapBrowserEvent): Boolean = noImpl
//            fun click(mapBrowserEvent: ol.MapBrowserEvent): Boolean = noImpl
//            fun doubleClick(mapBrowserEvent: ol.MapBrowserEvent): Boolean = noImpl
//            fun mouseOnly(mapBrowserEvent: ol.MapBrowserEvent): Boolean = noImpl
//            fun never(mapBrowserEvent: ol.MapBrowserEvent): Boolean = noImpl
//            fun noModifierKeys(mapBrowserEvent: ol.MapBrowserEvent): Boolean = noImpl
//            fun platformModifierKeyOnly(mapBrowserEvent: ol.MapBrowserEvent): Boolean = noImpl
//            fun pointerMove(mapBrowserEvent: ol.MapBrowserEvent): Boolean = noImpl
//            fun shiftKeyOnly(mapBrowserEvent: ol.MapBrowserEvent): Boolean = noImpl
//            fun singleClick(mapBrowserEvent: ol.MapBrowserEvent): Boolean = noImpl
//            fun targetNotEditable(mapBrowserEvent: ol.MapBrowserEvent): Boolean = noImpl
//        }
//        interface ConditionType {
//            @nativeInvoke
//            fun invoke(mapBrowseEvent: ol.MapBrowserEvent): Boolean
//        }
//    }
//    @native
//    object extent {
//        fun applyTransform(extent: ol.Extent, transformFn: ol.TransformFunction, destinationExtent: ol.Extent? = null): ol.Extent = noImpl
//        fun boundingExtent(coordinates: Array<ol.Coordinate>): ol.Extent = noImpl
//        fun buffer(extent: ol.Extent, value: Number, destinationExtent: ol.Extent? = null): ol.Extent = noImpl
//        fun containsCoordinate(extent: ol.Extent, coordinate: ol.Coordinate): Boolean = noImpl
//        fun containsExtent(extent1: ol.Extent, extent2: ol.Extent): Boolean = noImpl
//        fun containsXY(extent: ol.Extent, x: Number, y: Number): Boolean = noImpl
//        fun createEmpty(): ol.Extent = noImpl
//        fun equals(extent1: ol.Extent, extent2: ol.Extent): Boolean = noImpl
//        fun extend(extent1: ol.Extent, extent2: ol.Extent): ol.Extent = noImpl
//        fun getBottomLeft(extent: ol.Extent): ol.Coordinate = noImpl
//        fun getBottomRight(extent: ol.Extent): ol.Coordinate = noImpl
//        fun getCenter(extent: ol.Extent): ol.Coordinate = noImpl
//        fun getHeight(extent: ol.Extent): Number = noImpl
//        fun getIntersection(extent1: ol.Extent, extent2: ol.Extent, extent: ol.Extent? = null): ol.Extent = noImpl
//        fun getSize(extent: ol.Extent): ol.Size = noImpl
//        fun getTopLeft(extent: ol.Extent): ol.Coordinate = noImpl
//        fun getTopRight(extent: ol.Extent): ol.Coordinate = noImpl
//        fun getWidth(extent: ol.Extent): Number = noImpl
//        fun intersects(extent1: ol.Extent, extent2: ol.Extent): Boolean = noImpl
//        fun isEmpty(extent: ol.Extent): Boolean = noImpl
//    }
//    @native
//    object featureloader {
//        fun xhr(url: String, format: ol.format.Feature): ol.FeatureLoader = noImpl
//    }
//    @native
//    object format {
//        interface IGCZ : String
//        open class EsriJSON
//        open class Feature
//        open class GeoJSON(options: olx.format.GeoJSONOptions? = null) : ol.format.JSONFeature() {
//            open fun readFeature(source: dynamic /* Document | Node | JSON | String */, options: olx.format.ReadOptions? = null): ol.Feature = noImpl
//            open fun readFeatures(source: dynamic /* Document | Node | JSON | String */, options: olx.format.ReadOptions? = null): Array<ol.Feature> = noImpl
//            open fun readGeometry(source: dynamic /* Document | Node | JSON | String */, options: olx.format.ReadOptions? = null): ol.geom.Geometry = noImpl
//            open fun readProjection(source: dynamic /* Document | Node | JSON | String */): ol.proj.Projection = noImpl
//            open fun writeFeature(feature: ol.Feature, options: olx.format.WriteOptions? = null): String = noImpl
//            open fun writeFeatureObject(feature: ol.Feature, options: olx.format.WriteOptions? = null): JSON = noImpl
//            open fun writeFeatures(features: Array<ol.Feature>, options: olx.format.WriteOptions? = null): String = noImpl
//            open fun writeFeaturesObject(features: Array<ol.Feature>, options: olx.format.WriteOptions? = null): JSON = noImpl
//            open fun writeGeometry(geometry: ol.geom.Geometry, options: olx.format.WriteOptions? = null): String = noImpl
//            open fun writeGeometryObject(geometry: ol.geom.Geometry, options: olx.format.WriteOptions? = null): JSON = noImpl
//        }
//        open class GML
//        open class GML2
//        open class GML3
//        open class GMLBase
//        open class GPX
//        open class IGC
//        open class JSONFeature
//        open class KML
//        open class OSMXML
//        open class Polyline
//        open class TextFeature
//        open class TopoJSON
//        open class WFS {
//            open fun readFeatures(source: dynamic /* Document | Node | Object | String */, option: olx.format.ReadOptions? = null): Array<ol.Feature> = noImpl
//        }
//        open class WKT(opt_options: olx.format.WKTOptions? = null) {
//            open fun readFeature(source: dynamic /* Document | Node | JSON | String */, opt_options: olx.format.ReadOptions? = null): ol.Feature = noImpl
//            open fun readFeatures(source: dynamic /* Document | Node | JSON | String */, options: olx.format.ReadOptions? = null): Array<ol.Feature> = noImpl
//            open fun readGeometry(source: dynamic /* Document | Node | JSON | String */, options: olx.format.ReadOptions? = null): ol.geom.Geometry = noImpl
//            open fun writeFeature(feature: ol.Feature, options: olx.format.WriteOptions? = null): String = noImpl
//            open fun writeFeatures(features: Array<ol.Feature>, options: olx.format.WriteOptions? = null): String = noImpl
//            open fun writeGeometry(geometry: ol.geom.Geometry, options: olx.format.WriteOptions? = null): String = noImpl
//        }
//        open class WMSCapabilities
//        open class WMSGetFeatureInfo
//        open class WMTSCapabilities
//        open class XML
//        open class XMLFeature
//    }
    @native
    object geom {
        interface GeometryLayout /*: String*/
//        interface GeometryType : String
//        open class Circle : ol.geom.SimpleGeometry() {
//            open fun intersectsExtent(extent: ol.Extent): Boolean = noImpl
//            override fun transform(source: ol.proj.ProjectionLike, destination: ol.proj.ProjectionLike): ol.geom.Circle = noImpl
//        }
        open class Geometry : ol.Object() {
//            open fun getClosestPoint(point: ol.Coordinate, closestPoint: ol.Coordinate? = null): ol.Coordinate = noImpl
//            open fun getExtent(extent: ol.Extent? = null): ol.Extent = noImpl
//            open fun transform(source: ol.proj.ProjectionLike, destination: ol.proj.ProjectionLike): ol.geom.Geometry = noImpl
        }
//        open class GeometryCollection(geometries: Array<ol.geom.Geometry>? = null) : ol.geom.Geometry() {
//            open fun applyTransform(transformFn: ol.TransformFunction): Unit = noImpl
//            open fun clone(): ol.geom.GeometryCollection = noImpl
//            open fun getGeometries(): Array<Geometry> = noImpl
//            open fun getType(): ol.geom.GeometryType = noImpl
//            open fun intersectsExtent(extent: ol.Extent): Boolean = noImpl
//            open fun setGeometries(geometries: Array<ol.geom.Geometry>): Unit = noImpl
//        }
//        open class LinearRing(coordinates: Array<ol.Coordinate>, layout: ol.geom.GeometryLayout? = null) : SimpleGeometry() {
//            open fun clone(): ol.geom.LinearRing = noImpl
//            open fun getArea(): Number = noImpl
//            open fun getCoordinates(): Array<ol.Coordinate> = noImpl
//            open fun getType(): ol.geom.GeometryType = noImpl
//            open fun setCoordinates(coordinates: Array<ol.Coordinate>, layout: Any? = null): Unit = noImpl
//        }
//        open class LineString(coordinates: Array<ol.Coordinate>, layout: ol.geom.GeometryLayout? = null) : ol.geom.SimpleGeometry() {
//            open fun appendCoordinate(coordinate: ol.Coordinate): Unit = noImpl
//            open fun clone(): ol.geom.LineString = noImpl
//            open fun getCoordinateAtM(m: Number, extrapolate: Boolean? = null): ol.Coordinate = noImpl
//            open fun getCoordinates(): Array<ol.Coordinate> = noImpl
//            open fun getLength(): Number = noImpl
//            open fun getType(): ol.geom.GeometryType = noImpl
//            open fun intersectsExtent(extent: ol.Extent): Boolean = noImpl
//            open fun setCoordinates(coordinates: Array<ol.Coordinate>, layout: ol.geom.GeometryLayout? = null): Unit = noImpl
//        }
//        open class MultiLineString(coordinates: Array<Array<ol.Coordinate>>, layout: ol.geom.GeometryLayout? = null) : ol.geom.SimpleGeometry() {
//            open fun appendLineString(lineString: ol.geom.LineString): Unit = noImpl
//            open fun clone(): ol.geom.MultiLineString = noImpl
//            open fun getCoordinateAtM(m: Number, extrapolate: Boolean? = null, interpolate: Boolean? = null): ol.Coordinate = noImpl
//            open fun getCoordinates(): Array<Array<ol.Coordinate>> = noImpl
//            open fun getLineString(index: Number): ol.geom.LineString = noImpl
//            open fun getLineStrings(): Array<ol.geom.LineString> = noImpl
//            open fun getType(): ol.geom.GeometryType = noImpl
//            open fun intersectsExtent(extent: ol.Extent): Boolean = noImpl
//            open fun setCoordinates(coordinates: Array<Array<ol.Coordinate>>, layout: ol.geom.GeometryLayout? = null): Unit = noImpl
//        }
//        open class MultiPoint(coordinates: Array<ol.Coordinate>, layout: ol.geom.GeometryLayout? = null) : ol.geom.SimpleGeometry() {
//            open fun appendPoint(point: ol.geom.Point): Unit = noImpl
//            open fun clone(): ol.geom.MultiPoint = noImpl
//            open fun getCoordinates(): Array<ol.Coordinate> = noImpl
//            open fun getPoint(index: Number): ol.geom.Point = noImpl
//            open fun getPoints(): Array<ol.geom.Point> = noImpl
//            open fun getType(): ol.geom.GeometryType = noImpl
//            open fun intersectsExtent(extent: ol.Extent): Boolean = noImpl
//            open fun setCoordinates(coordinates: Array<ol.Coordinate>, layout: ol.geom.GeometryLayout? = null): Unit = noImpl
//        }
//        open class MultiPolygon(coordinates: Array<Array<Array<ol.Coordinate>>>, layout: ol.geom.GeometryLayout? = null) : ol.geom.SimpleGeometry() {
//            open fun appendPolygon(polygon: ol.geom.Polygon): Unit = noImpl
//            open fun clone(): ol.geom.MultiPolygon = noImpl
//            open fun getArea(): Number = noImpl
//            open fun getCoordinates(right: Boolean? = null): Array<Array<Array<ol.Coordinate>>> = noImpl
//            open fun getInteriorPoints(): ol.geom.MultiPoint = noImpl
//            open fun getPolygon(index: Number): ol.geom.Polygon = noImpl
//            open fun getPolygons(): Array<ol.geom.Polygon> = noImpl
//            open fun getType(): ol.geom.GeometryType = noImpl
//            open fun intersectsExtent(extent: ol.Extent): Boolean = noImpl
//            open fun setCoordinates(coordinates: Array<Array<Array<ol.Coordinate>>>, layout: ol.geom.GeometryLayout? = null): Unit = noImpl
//        }
        open class Point(coordinates: ol.Coordinate, layout: ol.geom.GeometryLayout? = null) : SimpleGeometry() {
//            open fun clone(): ol.geom.Point = noImpl
//            open fun getCoordinates(): ol.Coordinate = noImpl
//            open fun getType(): ol.geom.GeometryType = noImpl
//            open fun intersectsExtent(extent: ol.Extent): Boolean = noImpl
//            open fun setCoordinates(coordinates: ol.Coordinate, layout: ol.geom.GeometryLayout? = null): Unit = noImpl
        }
//        open class Polygon(coordinates: Array<Array<ol.Coordinate>>, layout: ol.geom.GeometryLayout? = null) : SimpleGeometry() {
//            open fun appendLinearRing(linearRing: ol.geom.LinearRing): Unit = noImpl
//            open fun clone(): ol.geom.Polygon = noImpl
//            open fun getArea(): Number = noImpl
//            open fun getCoordinates(right: Boolean? = null): Array<Array<ol.Coordinate>> = noImpl
//            open fun getInteriorPoint(): ol.geom.Point = noImpl
//            open fun getLinearRing(index: Number): ol.geom.LinearRing = noImpl
//            open fun getLinearRings(): Array<ol.geom.LinearRing> = noImpl
//            open fun getType(): ol.geom.GeometryType = noImpl
//            open fun intersectsExtent(extent: ol.Extent): Boolean = noImpl
//            open fun setCoordinates(coordinates: Array<Array<ol.Coordinate>>, layout: ol.geom.GeometryLayout? = null): Unit = noImpl
//            companion object {
//                fun circular(sphere: ol.Sphere, center: ol.Coordinate, radius: Number, n: Number? = null): ol.geom.Polygon = noImpl
//            }
//        }
        open class SimpleGeometry : ol.geom.Geometry() {
//            open fun applyTransform(transformFn: ol.TransformFunction): Unit = noImpl
//            open fun getFirstCoordinate(): ol.Coordinate = noImpl
//            open fun getLastCoordinate(): ol.Coordinate = noImpl
//            open fun getLayout(): ol.geom.GeometryLayout = noImpl
//            open fun translate(deltaX: Number, deltaY: Number): Unit = noImpl
        }
    }
//    @native
//    object has {
//
//    }
//    @native
//    object interaction {
//        open class DoubleClickZoom
//        open class DragAndDrop
//        open class DragAndDropEvent
//        open class DragBox
//        open class DragPan
//        open class DragRotate
//        open class DragRotateAndZoom
//        open class DragZoom
//        open class Draw(opt_options: olx.interaction.DrawOptions? = null) : ol.interaction.Pointer()
//        open class DrawEvent
//        open class Interaction : ol.Object()
//        open class KeyboardPan
//        open class KeyboardZoom
//        open class Modify(opt_options: olx.interaction.ModifyOptions? = null) : ol.interaction.Pointer()
//        open class MouseWheelZoom
//        open class PinchRotate
//        open class PinchZoom
//        open class Pointer : ol.interaction.Interaction()
//        open class Select(opt_options: olx.interaction.SelectOptions? = null) : ol.interaction.Interaction() {
//            open fun getLayer(): ol.layer.Layer = noImpl
//            open fun getFeatures(): ol.Collection<ol.Feature> = noImpl
//        }
//        open class Snap
//        fun defaults(opts: olx.interaction.DefaultsOptions): ol.Collection<ol.interaction.Interaction> = noImpl
//        interface DrawGeometryFunctionType {
//            @nativeInvoke
//            fun invoke(coordinates: ol.Coordinate, geom: ol.geom.Geometry? = null): ol.geom.Geometry
//        }
//        interface SelectFilterFunction {
//            @nativeInvoke
//            fun invoke(feature: dynamic /* ol.Feature | ol.render.Feature */, layer: ol.layer.Layer): Boolean
//        }
//    }
    @native
    object layer {
        open class Base(options: olx.layer.BaseOptions? = null) : ol.Object() {
//            open fun getBrightness(): Number = noImpl
//            open fun getContrast(): Number = noImpl
//            open fun getExtent(): ol.Extent = noImpl
//            open fun getHue(): Number = noImpl
//            open fun getMaxResolution(): Number = noImpl
//            open fun getMinResolution(): Number = noImpl
//            open fun getOpacity(): Number = noImpl
//            open fun getSaturation(): Number = noImpl
//            open fun getVisible(): Boolean = noImpl
//            open fun setBrightness(brigthness: Number): Unit = noImpl
//            open fun setContrast(contrast: Number): Unit = noImpl
//            open fun setExtent(extent: ol.Extent? = null): Unit = noImpl
//            open fun setHue(hue: Number): Unit = noImpl
//            open fun setMaxResolution(maxResolution: Number): Unit = noImpl
//            open fun setMinResolution(minResolution: Number): Unit = noImpl
//            open fun setOpacity(opacity: Number): Unit = noImpl
//            open fun setSaturation(saturation: Number): Unit = noImpl
//            open fun setVisible(visible: Boolean): Unit = noImpl
        }
//        open class Group(options: olx.layer.GroupOptions? = null) : ol.layer.Base() {
//            open fun getLayers(): ol.Collection<ol.layer.Base> = noImpl
//            open fun setLayers(layers: ol.Collection<ol.layer.Base>): Unit = noImpl
//        }
//        open class Heatmap(options: olx.layer.HeatmapOptions? = null) : ol.layer.Vector() {
//            open fun getBlur(): Number = noImpl
//            open fun getGradient(): Array<String> = noImpl
//            open fun getRadius(): Number = noImpl
//            open fun setBlur(blur: Number): Unit = noImpl
//            open fun setGradient(colors: Array<String>): Unit = noImpl
//            open fun setRadius(radius: Number): Unit = noImpl
//        }
        open class Image(options: olx.layer.ImageOptions? = null) : ol.layer.Layer() {
//            override fun getSource(): ol.source.Image = noImpl
        }
        open class Layer(options: olx.layer.LayerOptions? = null) : ol.layer.Base() {
//            open fun getSource(): ol.source.Source = noImpl
//            open fun setSource(source: ol.source.Source): Unit = noImpl
        }
        open class Tile(options: olx.layer.TileOptions? = null) : ol.layer.Layer() {
//            open fun getPreload(): Number = noImpl
//            override fun getSource(): ol.source.Tile = noImpl
//            open fun getUseInterimTilesOnError(): Boolean = noImpl
//            open fun setPreload(preload: Number): Unit = noImpl
//            open fun setUseInterimTilesOnError(useInterimTilesOnError: Boolean): Unit = noImpl
        }
        open class Vector(options: olx.layer.VectorOptions? = null) : ol.layer.Layer() {
//            override fun getSource(): ol.source.Vector = noImpl
//            open fun getStyle(): dynamic /* ol.style.Style | Array<ol.style.Style> | ol.style.StyleFunction */ = noImpl
//            open fun getStyleFunction(): ol.style.StyleFunction = noImpl
//            open fun setStyle(): Unit = noImpl
//            open fun setStyle(style: ol.style.Style): Unit = noImpl
//            open fun setStyle(style: Array<ol.style.Style>): Unit = noImpl
//            open fun setStyle(style: ol.style.StyleFunction): Unit = noImpl
//            open fun setMap(map: ol.Map): Unit = noImpl
        }
    }
//    @native
//    object loadingstrategy {
//        fun all(extent: ol.Extent, resolution: Number): Array<ol.Extent> = noImpl
//        fun bbox(extent: ol.Extent, resolution: Number): Array<ol.Extent> = noImpl
//        fun tile(tileGrid: ol.tilegrid.TileGrid): ol.LoadingStrategy = noImpl
//    }
    @native
    object proj {
//        interface ProjectionLike : String
//        interface Units : String
//        var METERS_PER_UNIT: Object = noImpl
//        fun addCoordinateTransforms(source: ProjectionLike, destination: ProjectionLike, forward: (coordinate: Coordinate) -> Coordinate, inverse: (coordinate: Coordinate) -> Coordinate): Unit = noImpl
//        fun addEquivalentProjections(projections: Array<Projection>): Unit = noImpl
//        fun addProjection(projection: Projection): Unit = noImpl
//        fun fromLonLat(coordinate: Coordinate, opt_projection: ProjectionLike): Coordinate = noImpl
//        fun get(projectionLike: ProjectionLike): Projection = noImpl
//        fun getTransform(source: ProjectionLike, destination: ProjectionLike): ol.TransformFunction = noImpl
//        fun toLonLat(coordinate: Coordinate, projection: ProjectionLike): Coordinate = noImpl
//        fun transform(coordinate: Coordinate, source: ProjectionLike, destination: ProjectionLike): Coordinate = noImpl
//        fun transformExtent(extent: Extent, source: ProjectionLike, destination: ProjectionLike): Extent = noImpl
        open class Projection(options: olx.Projection) {
//            open fun getExtent(): Extent = noImpl
        }
    }
//    @native
//    object render {
//        open class Event
//        open class VectorContext
//        open class Feature {
//            open fun get(key: String): Any = noImpl
//            open fun getExtent(): ol.Extent = noImpl
//            open fun getGeometry(): ol.geom.Geometry = noImpl
//            open var getProperties: Array<Object> = noImpl
//            open fun getType(): ol.geom.GeometryType = noImpl
//        }
//        @native
//        object canvas {
//            open class Immediate
//        }
//    }
    @native
    object source {
//        open class BingMaps
//        open class Cluster
        open class Image
//        open class ImageCanvas
//        open class ImageEvent
//        open class ImageMapGuide
//        open class ImageStatic
//        open class ImageVector
//        open class ImageWMS(options: olx.ImageWMSOptions)
        open class MapQuest(options: Any) : Source()
//        open class OSM
        open class Source
//        open class Stamen
        open class Tile : Source()
//        open class TileArcGISRest
//        open class TileDebug
//        open class TileEvent
//        open class TileImage
//        open class TileJSON
//        open class TileUTFGrid
//        open class TileVector
//        open class TileWMS(options: olx.TileWMSOptions)
        open class Vector(opts: olx.source.VectorOptions? = null) : Source() {
            open fun addFeature(feature: ol.Feature): Unit = noImpl
//            open fun addFeatures(features: Array<ol.Feature>): Unit = noImpl
//            open fun clear(fast: Boolean? = null): Unit = noImpl
//            open fun getExtent(): ol.Extent = noImpl
//            open fun getFeaturesInExtent(extent: ol.Extent): Array<ol.Feature> = noImpl
//            open fun getFeatures(): Array<ol.Feature> = noImpl
//            open fun getFeaturesAtCoordinate(coordinate: ol.Coordinate): Array<ol.Feature> = noImpl
        }
//        open class VectorEvent
//        open class WMTS(options: olx.source.WMTSOptions)
//        open class XYZ
//        open class Zoomify
//        @native
//        object wms {
//            interface ServerType : String
//        }
//        interface State : String
//        interface WMTSRequestEncoding : String
    }
    @native
    object style {
//        open class AtlasManager
//        open class Circle(opt_options: olx.style.CircleOptions? = null) : Image()
//        open class Fill(opt_options: olx.style.FillOptions? = null) {
//            open fun getColor(): dynamic /* ol.Color | String */ = noImpl
//            open fun setColor(color: dynamic /* ol.Color | String */): Unit = noImpl
//            open fun getChecksum(): String = noImpl
//        }
        open class Icon(option: olx.style.IconOptions) : Image()
        open class Image {
//            open fun getOpacity(): Number = noImpl
//            open fun getRotateWithView(): Boolean = noImpl
//            open fun getRotation(): Number = noImpl
//            open fun getScale(): Number = noImpl
//            open fun getSnapToPiexl(): Boolean = noImpl
//            open fun setOpacity(opacity: Number): Unit = noImpl
//            open fun setRotation(rotation: Number): Unit = noImpl
//            open fun setScale(scale: Number): Unit = noImpl
        }
//        interface GeometryFunction {
//            @nativeInvoke
//            fun invoke(feature: Feature): ol.geom.Geometry
//        }
//        open class RegularShape
//        open class Stroke(opts: olx.style.StrokeOptions? = null) {
//            open fun getColor(): dynamic /* ol.Color | String */ = noImpl
//            open fun getLineCap(): String = noImpl
//            open fun getLineDash(): Array<Number> = noImpl
//            open fun getLineJoin(): String = noImpl
//            open fun getMitterLimit(): Number = noImpl
//            open fun getWidth(): Number = noImpl
//            open fun setColor(color: dynamic /* ol.Color | String */): Unit = noImpl
//            open fun setLineCap(lineCap: String): Unit = noImpl
//            open fun setLineDash(lineDash: Array<Number>): Unit = noImpl
//            open fun setLineJoin(lineJoin: String): Unit = noImpl
//            open fun setMiterLimit(miterLimit: Number): Unit = noImpl
//            open fun setWidth(width: Number): Unit = noImpl
//        }
        open class Style(opts: olx.style.StyleOptions) {
//            open fun getFill(): ol.style.Fill = noImpl
//            open fun getGeometry(): dynamic /* String | ol.geom.Geometry | ol.style.GeometryFunction */ = noImpl
//            open fun getGeometryFunction(): ol.style.GeometryFunction = noImpl
//            open fun getImage(): ol.style.Image = noImpl
//            open fun getStroke(): ol.style.Stroke = noImpl
//            open fun getText(): ol.style.Text = noImpl
//            open fun getZIndex(): Number = noImpl
//            open fun setGeometry(geometry: dynamic /* String | ol.geom.Geometry | ol.style.GeometryFunction */): Unit = noImpl
//            open fun setZIndex(zIndex: Number): Unit = noImpl
        }
//        open class Text(opt: olx.style.TextOptions? = null) {
//            open fun getFont(): String = noImpl
//            open fun getOffsetX(): Number = noImpl
//            open fun getOffsetY(): Number = noImpl
//            open fun getFill(): Fill = noImpl
//            open fun getRotation(): Number = noImpl
//            open fun getScale(): Number = noImpl
//            open fun getStroke(): Stroke = noImpl
//            open fun getText(): String = noImpl
//            open fun getTextAlign(): String = noImpl
//            open fun getTextBaseline(): String = noImpl
//            open fun setFont(font: String): Unit = noImpl
//            open fun setOffsetX(offsetX: Number): Unit = noImpl
//            open fun setOffsetY(offsetY: Number): Unit = noImpl
//            open fun setFill(fill: Fill): Unit = noImpl
//            open fun setRotation(rotation: Number): Unit = noImpl
//            open fun setScale(scale: Number): Unit = noImpl
//            open fun setStroke(stroke: Stroke): Unit = noImpl
//            open fun setText(text: String): Unit = noImpl
//            open fun setTextAlign(textAlign: String): Unit = noImpl
//            open fun setTextBaseline(textBaseline: String): Unit = noImpl
//        }
//        interface StyleFunction {
//            @nativeInvoke
//            fun invoke(feature: ol.Feature, resolution: Number): ol.style.Style
//        }
    }
//    @native
//    object tilegrid {
//        interface `T$0` {
//            @nativeInvoke
//            fun invoke(tilecoord: ol.TileCoord, projection: ol.proj.Projection): ol.TileCoord
//        }
//        open class TileGrid(options: olx.tilegrid.TileGridOptions) {
//            open fun createTileCoordTransform(): `T$0` = noImpl
//            open fun getMaxZoom(): Number = noImpl
//            open fun getMinZoom(): Number = noImpl
//            open fun getOrigin(z: Number): ol.Coordinate = noImpl
//            open fun getResolution(z: Number): Number = noImpl
//            open fun getResolutions(): Array<Number> = noImpl
//            open fun getTileCoordForCoordAndResolution(coordinate: ol.Coordinate, resolution: Number, tileCoord: ol.TileCoord? = null): ol.TileCoord = noImpl
//            open fun getTileCoordForCoordAndZ(coordinate: ol.Coordinate, z: Number, tileCoord: ol.TileCoord? = null): ol.TileCoord = noImpl
//            open fun getTileSize(z: Number): dynamic /* Number | ol.Size */ = noImpl
//        }
//        open class WMTS(options: olx.tilegrid.WMTSOptions) : TileGrid() {
//            open fun createFromCapabilitiesMatrixSet(matrixSet: Any, extent: ol.Extent): ol.tilegrid.WMTS = noImpl
//            open fun getMatrixIds(): Array<String> = noImpl
//        }
//        open class Zoomify(options: olx.tilegrid.ZoomifyOptions? = null) : TileGrid()
//        fun createXYZ(options: olx.tilegrid.XYZOptions? = null): ol.tilegrid.TileGrid = noImpl
//    }
//    @native
//    object webgl {
//        open class Context(canvas: HTMLCanvasElement, gl: WebGLRenderingContext) {
//            open fun getGL(): WebGLRenderingContext = noImpl
//            open fun getHitDetectionFramebuffer(): WebGLFramebuffer = noImpl
//            open fun useProgram(program: WebGLProgram): Boolean = noImpl
//        }
//    }
//    fun CanvasFunctionType(extent: Extent, resolution: Number, pixelRatio: Number, size: Size, projection: proj.Projection): HTMLCanvasElement = noImpl
//    interface Color : Array<Number>
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
//    interface RendererType : String
//    interface Size : Array<Number>
//    interface TileCoord : Array<Number>
//    interface CoordinateFormatType {
//        @nativeInvoke
//        fun invoke(coordinate: Coordinate? = null): String
//    }
    interface FeatureLoader {
        @nativeInvoke
        fun invoke(extent: ol.Extent, number: Number, projection: ol.proj.Projection): String
    }
//    interface FeatureStyleFunction {
//        @nativeInvoke
//        fun invoke(resolution: Number): ol.style.Style
//    }
//    interface LoadingStrategy {
//        @nativeInvoke
//        fun invoke(extent: ol.Extent, resolution: Number): Array<ol.Extent>
//    }
//    interface PreRenderFunction {
//        @nativeInvoke
//        fun invoke(map: ol.Map, frameState: olx.FrameState? = null): Boolean
//    }
//    interface TransformFunction {
//        @nativeInvoke
//        fun invoke(input: Array<Number>, output: Array<Number>? = null, dimension: Number? = null): Array<Number>
//    }
}
