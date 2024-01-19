Function ongetfailedsteamconnection%(arg0%, arg1%, arg2%)
    If (p2psessionrequestfail = $00) Then
        p2psessionrequestfail = bp_getfunctionpointer()
        Return $00
    EndIf
    debuglog(("Steam ID: " + (Str bs_memory_peekint(arg0, $00))))
    debuglog(("Error: " + (Str bs_memory_peekbyte(arg0, $04))))
    bs_isteamnetworking_closep2psessionwithuser(bs_steamnetworking(), udp_fillsteam(bs_memory_peekint(arg0, $00)))
    If (((networkserver\Field50 <> $00) And (networkserver\Field42 = $00)) <> 0) Then
        bs_steammatchmaking_leavelobby(bs_steammatchmaking(), networkserver\Field50)
        networkserver\Field50 = $00
    EndIf
    Return $00
End Function
