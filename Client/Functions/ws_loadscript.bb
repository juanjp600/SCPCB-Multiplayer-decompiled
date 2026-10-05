Function ws_loadscript%(arg0$)
    Local local0.se_script
    Local local1.workshopthread
    If (se_isvalidscript(arg0) = $00) Then
        Return $00
    EndIf
    If (filetype(arg0) = $01) Then
        local0 = se_loadscriptexec(arg0)
        If (local0 = Null) Then
            Return $00
        EndIf
        local1 = (New workshopthread)
        local1\Field2 = local0
        local1\Field0 = arg0
        local1\Field1 = ws_stripscript(arg0)
        skynet_onload($01)
        init_publics_for_script(local1\Field2)
        public_inqueue($13, $00)
        public_update_current(local1\Field2, $00)
        public_clear()
    EndIf
    Return $00
End Function
