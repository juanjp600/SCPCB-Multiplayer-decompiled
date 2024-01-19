Function steambrowser_callback_startrequest%(arg0%, arg1%, arg2%)
    Local local0.steambrowser
    If (steambrowser_callback_startrequest_p = $00) Then
        steambrowser_callback_startrequest_p = bp_getfunctionpointer()
        steambrowser_callback_startrequest_c = bs_callback_new(steambrowser_callback_startrequest_p)
        Return $00
    EndIf
    local0 = steambrowser_find(bs_memory_peekint(arg0, $00), $00)
    If (local0 <> Null) Then
        bs_isteamhtmlsurface_allowstartrequest(bs_steamhtmlsurface(), local0\Field0, $01)
    EndIf
    Return $00
End Function
