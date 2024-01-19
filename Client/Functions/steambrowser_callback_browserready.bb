Function steambrowser_callback_browserready%(arg0%, arg1%, arg2%)
    Local local0.steambrowser
    If (steambrowser_callback_browserready_p = $00) Then
        steambrowser_callback_browserready_p = bp_getfunctionpointer()
        steambrowser_callback_browserready_c = bs_callback_new(steambrowser_callback_browserready_p)
        Return $00
    EndIf
    local0 = steambrowser_find($00, arg2)
    If (local0 <> Null) Then
        local0\Field0 = bs_memory_peekint(arg0, $00)
        steambrowser_setsize(local0, local0\Field2[$00], local0\Field2[$01])
        steambrowser_loadurl(local0, local0\Field3, "")
        bs_long_destroy(local0\Field1)
        local0\Field1 = $00
    EndIf
    Return $00
End Function
