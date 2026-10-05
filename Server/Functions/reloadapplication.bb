Function reloadapplication%()
    If (filetype("server.exe") <> $01) Then
        Return $00
    EndIf
    executeapp("server.exe")
    If (server\Field87\Field7 <> 0) Then
        gs_logoff()
        gs_shutdown()
    EndIf
    end()
    Return $00
End Function
