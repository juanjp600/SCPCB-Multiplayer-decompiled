Function steam_warningmessagehook%(arg0%, arg1%)
    Local local0$
    If (steam_warningmessagehook_callback = $00) Then
        steam_warningmessagehook_callback = bp_getfunctionpointer()
        Return $00
    EndIf
    local0 = ""
    If (arg0 = $01) Then
        local0 = "[Warning]"
    Else
        local0 = "[Info]"
    EndIf
    local0 = (local0 + (Str peekmemorystringc(arg1, $FFFFFFFF)))
    debuglog(("[Steam]" + local0))
    Return $00
End Function
