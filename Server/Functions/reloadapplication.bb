Function reloadapplication%()
    Local local0%
    If (filetype("server.exe") <> $01) Then
        Return $00
    EndIf
    executeapp("server.exe")
    local0 = api_openprocess($01, $00, api_getcurrentprocessid())
    api_terminateprocess(local0, $01)
    api_closehandle(local0)
    end()
    Return $01
    Return $00
End Function
