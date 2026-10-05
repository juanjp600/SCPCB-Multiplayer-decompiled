Function banlist_updateversion%(arg0$, arg1$)
    Local local0%
    Local local1%
    If (filetype(arg1) <> $00) Then
        Return $00
    EndIf
    createfile(arg1)
    If (filesize(arg0) <> $00) Then
        local0 = openfile(arg0)
        local1 = openfile(arg1)
        seekfile(local1, filesize((Str local1)))
        While (eof(local0) = $00)
            writeline(local1, readline(local0))
        Wend
        closefile(local0)
        closefile(local1)
    EndIf
    deletefile(arg0)
    Return $00
End Function
