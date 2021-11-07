class SocketConnector {
    constructor(path) {
        let tmp = document.querySelector("#tmp-id");
        if (tmp == null) return;
        let id = tmp.getAttribute("m-id");
        tmp.remove();
        this.ws = new WebSocket(`ws://localhost:8080/Javbook/ws/${path}`);
        this.ws.onopen = () => {
            this.ws.send(JSON.stringify(["i", id]));
        }
    }

    sendTo(to, data) {
        this.ws.send(JSON.stringify([{
            "to": to,
            "data": data    
        }]))
    }

    addEvent(type, func) {
        if (type === "message") this.ws.addEventListener("message", e => func(JSON.parse(e.data)));
        else this.ws.addEventListener(type, func);
    }
}