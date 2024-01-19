Function onrequestgamelobby%(arg0%, arg1%, arg2%)
    If (gamelobbyrequest = $00) Then
        gamelobbyrequest = bp_getfunctionpointer()
        Return $00
    EndIf
    If (((udp_getstream() = $00) And (udp_getconnection() = $00)) <> 0) Then
        networkserver\Field50 = bs_csteamid_froml(arg0)
        bs_steammatchmaking_joinlobby(bs_steammatchmaking(), networkserver\Field50)
    EndIf
    Return $00
End Function
