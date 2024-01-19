Function ws_loadscript%(arg0$)
    Local local0.workshopthread
    If (filetype(arg0) = $01) Then
        debuglog(("loaded: " + arg0))
        local0 = (New workshopthread)
        local0\Field2 = se_loadscriptexec(arg0)
        local0\Field0 = arg0
        local0\Field1 = ws_stripscript(arg0)
        skynet_onload($01)
        init_publics_for_script(local0\Field2)
        public_inqueue($13, $00)
        public_update_current(local0\Field2, $00)
        public_clear()
    EndIf
    Return $00
End Function
