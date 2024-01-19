Function getinistring2$(arg0$, arg1%, arg2$, arg3$)
    Local local0$
    Local local1%
    Local local2%
    Local local3$
    local0 = ""
    local1 = readfile(arg0)
    local2 = $00
    While (eof(local1) = $00)
        local3 = readline(local1)
        local2 = (local2 + $01)
        If (local2 = arg1) Then
            Repeat
                local0 = readline(local1)
                If (lower(trim(left(local0, (Int max((Float (instr(local0, "=", $01) - $01)), 0.0))))) = lower(arg2)) Then
                    closefile(local1)
                    Return trim(right(local0, (len(local0) - instr(local0, "=", $01))))
                EndIf
            Until (((left(local0, $01) = "[") Or eof(local1)) <> 0)
            closefile(local1)
            Return arg3
        EndIf
    Wend
    closefile(local1)
    Return arg3
    Return ""
End Function
