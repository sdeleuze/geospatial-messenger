package io.spring.messenger.web

import org.springframework.http.MediaType
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.util.*
import java.util.Collections.synchronizedSet

class SseBroadcaster {

    private var sseEmitters = synchronizedSet(HashSet<SseEmitter>());

    fun subscribe(): SseEmitter {
        val sseEmitter: SseEmitter = SseEmitter()
        sseEmitter.onCompletion({ this.sseEmitters.remove(sseEmitter) });
        this.sseEmitters.add(sseEmitter);
        return sseEmitter
    }

    fun send(o:Any) {
        synchronized (sseEmitters) {
            sseEmitters.iterator().forEach { it.send(o, MediaType.APPLICATION_JSON) }
        }
    }
}

