Function ini_filetostring$(arg0$)
    Local local0$
    Local local1%
    local0 = ""
    local1 = readfile(arg0)
    If (local1 <> $00) Then
        While (eof(local1) = $00)
            local0 = ((local0 + readline(local1)) + chr($00))
        Wend
        closefile(local1)
    EndIf
    Return local0
    Return ""
End Function
