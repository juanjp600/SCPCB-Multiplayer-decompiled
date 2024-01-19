Function multiplayer_put_error%(arg0$, arg1$)
    Local local0%
    If (millisecs() < error_rate) Then
        Return $00
    EndIf
    If (filetype(arg0) = $00) Then
        createfile(arg0)
    EndIf
    local0 = openfile(arg0)
    seekfile(local0, filesize(arg0))
    writeline(local0, arg1)
    closefile(local0)
    error_rate = (millisecs() + $3E8)
    Return $00
End Function
