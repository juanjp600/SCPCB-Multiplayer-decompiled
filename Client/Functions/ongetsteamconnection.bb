Function ongetsteamconnection%(arg0%, arg1%, arg2%)
    If (p2psessionrequest = $00) Then
        p2psessionrequest = bp_getfunctionpointer()
        Return $00
    EndIf
    If (networkserver\Field49 <> 0) Then
        bs_isteamnetworking_acceptp2psessionwithuser(bs_steamnetworking(), arg0)
        udp_writebyte($7D)
        udp_writebyte($02)
        udp_sendmessageinternal($00, arg0, $00, $02)
        debuglog(((("Sended message to " + (Str arg0)) + " AccountID: ") + (Str bs_csteamid_getaccountid(arg0))))
    EndIf
    Return $00
End Function
