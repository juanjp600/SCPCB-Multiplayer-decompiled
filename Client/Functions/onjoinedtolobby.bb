Function onjoinedtolobby%(arg0%, arg1%, arg2%)
    Local local0%
    Local local1%
    If (joinlobbyrequest = $00) Then
        joinlobbyrequest = bp_getfunctionpointer()
        Return $00
    EndIf
    networkserver\Field50 = bs_csteamid_froml(arg0)
    If ((((networkserver\Field42 = $00) And (udp_getstream() = $00)) And (udp_getconnection() = $00)) <> 0) Then
        local0 = (Int bs_steammatchmaking_getlobbydata(bs_steammatchmaking(), networkserver\Field50, "HostSteam"))
        local1 = createbank($01)
        pokebyte(local1, $00, $7E)
        bs_isteamnetworking_sendp2ppacket(bs_steamnetworking(), udp_fillsteam(local0), local1, $01, $02, $00)
        freebank(local1)
        debuglog(("Connected to: " + (Str networkserver\Field50)))
    EndIf
    Return $00
End Function
