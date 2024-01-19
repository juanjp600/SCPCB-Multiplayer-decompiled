Function onlobbycreated%(arg0%, arg1%, arg2%)
    Local local0%
    If (lobbycreated_t = $00) Then
        lobbycreated_t = bp_getfunctionpointer()
        Return $00
    EndIf
    If (bs_memory_peekint(arg0, $00) = $01) Then
        local0 = bs_csteamid_froml((arg0 + $08))
        debuglog(("Setting lobby " + (Str bs_csteamid_islobby(local0))))
        debuglog(("Lobby: " + (Str bs_csteamid_getaccountid(local0))))
        debuglog(("MyID: " + (Str bs_csteamid_getaccountid(bs_isteamuser_getsteamid(bs_steamuser())))))
        bs_steammatchmaking_setlobbydata(bs_steammatchmaking(), local0, "HostSteam", (Str currentsteamid))
    EndIf
    Return $00
End Function
