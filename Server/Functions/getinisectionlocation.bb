Function getinisectionlocation%(arg0$, arg1$)
    Local local0%
    Local local1%
    Local local2%
    Local local3$
    local1 = readfile(arg0)
    arg1 = lower(arg1)
    local2 = $00
    While (eof(local1) = $00)
        local3 = readline(local1)
        local2 = (local2 + $01)
        If (left(local3, $01) = "[") Then
            local3 = lower(local3)
            local0 = instr(local3, arg1, $01)
            If (local0 > $00) Then
                If (((mid(local3, (local0 - $01), $01) = "[") Or (mid(local3, (local0 - $01), $01) = "|")) <> 0) Then
                    closefile(local1)
                    Return local2
                EndIf
            EndIf
        EndIf
    Wend
    closefile(local1)
    Return $00
End Function
