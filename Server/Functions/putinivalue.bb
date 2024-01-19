Function putinivalue%(arg0$, arg1$, arg2$, arg3$)
    Local local0$
    Local local1$
    Local local2$
    Local local3%
    Local local4%
    Local local5$
    Local local6%
    Local local7%
    Local local8%
    Local local9$
    Local local10%
    arg1 = (("[" + trim(arg1)) + "]")
    local0 = upper(arg1)
    arg2 = trim(arg2)
    arg3 = trim(arg3)
    local1 = arg0
    local2 = ini_filetostring(local1)
    local3 = $00
    local4 = $00
    local5 = ""
    local6 = writefile(local1)
    If (local6 = $00) Then
        Return $00
    EndIf
    local7 = $01
    local8 = instr(local2, chr($00), $01)
    While (local8 <> $00)
        local9 = mid(local2, local7, (local8 - local7))
        If (local9 <> "") Then
            If (((left(local9, $01) = "[") And (right(local9, $01) = "]")) <> 0) Then
                If (((local5 = local0) And (local3 = $00)) <> 0) Then
                    local3 = ini_createkey(local6, arg2, arg3)
                EndIf
                local5 = upper(ini_createsection(local6, local9))
                If (local5 = local0) Then
                    local4 = $01
                EndIf
            ElseIf (left(local9, $01) = ":") Then
                writeline(local6, local9)
            Else
                local10 = instr(local9, "=", $01)
                If (local10 <> $00) Then
                    If (((local5 = local0) And (upper(trim(left(local9, (local10 - $01)))) = upper(arg2))) <> 0) Then
                        If (arg3 <> "") Then
                            ini_createkey(local6, arg2, arg3)
                        EndIf
                        local3 = $01
                    Else
                        writeline(local6, local9)
                    EndIf
                EndIf
            EndIf
        EndIf
        local7 = (local8 + $01)
        local8 = instr(local2, chr($00), local7)
    Wend
    If (local3 = $00) Then
        If (local4 = $00) Then
            ini_createsection(local6, arg1)
        EndIf
        ini_createkey(local6, arg2, arg3)
    EndIf
    closefile(local6)
    Return $01
    Return $00
End Function
