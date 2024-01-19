Function rowtext%(arg0$, arg1#, arg2#, arg3#, arg4#, arg5%, arg6#, arg7%)
    Local local0%
    Local local1%
    Local local2$
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7$
    Local local8$
    Local local9%
    If (1.0 > arg4) Then
        arg4 = smallest_power_two
    EndIf
    local0 = $00
    local1 = (Int ((Float aastringheight(arg0)) + arg6))
    While (len(arg0) > $00)
        local6 = instr(arg0, " ", $01)
        If (local6 = $00) Then
            local6 = len(arg0)
        EndIf
        local7 = left(arg0, local6)
        local8 = trim(local7)
        local9 = $00
        If (((arg3 < (Float aastringwidth((local2 + local7)))) And (arg3 >= (Float aastringwidth((local2 + local8))))) <> 0) Then
            local7 = local8
            local9 = $01
        EndIf
        If (arg3 < (Float aastringwidth((local2 + local7)))) Then
            If (arg5 <> 0) Then
                If (arg7 <> 0) Then
                    local3 = colorred()
                    local4 = colorgreen()
                    local5 = colorblue()
                    color($00, $00, $00)
                    aatext((Int ((((arg3 / 2.0) + arg1) - (Float (aastringwidth(local2) Sar $01))) + 1.0)), (Int (((Float (local0 * local1)) + arg2) + 1.0)), local2, $00, $00, 1.0)
                    color(local3, local4, local5)
                EndIf
                aatext((Int (((arg3 / 2.0) + arg1) - (Float (aastringwidth(local2) Sar $01)))), (Int ((Float (local0 * local1)) + arg2)), local2, $00, $00, 1.0)
            Else
                If (arg7 <> 0) Then
                    local3 = colorred()
                    local4 = colorgreen()
                    local5 = colorblue()
                    color($00, $00, $00)
                    aatext((Int (arg1 + 1.0)), (Int (((Float (local0 * local1)) + arg2) + 1.0)), local2, $00, $00, 1.0)
                    color(local3, local4, local5)
                EndIf
                aatext((Int arg1), (Int ((Float (local0 * local1)) + arg2)), local2, $00, $00, 1.0)
            EndIf
            local0 = (local0 + $01)
            local2 = ""
        Else
            local2 = (local2 + local7)
            arg0 = right(arg0, (len(arg0) - (len(local7) + local9)))
        EndIf
        If (arg4 < (Float ((local0 + $01) * local1))) Then
            Exit
        EndIf
    Wend
    If (((local2 <> "") And (arg4 >= (Float (local0 + $01)))) <> 0) Then
        If (arg5 <> 0) Then
            If (arg7 <> 0) Then
                local3 = colorred()
                local4 = colorgreen()
                local5 = colorblue()
                color($00, $00, $00)
                aatext((Int ((((arg3 / 2.0) + arg1) - (Float (aastringwidth(local2) Sar $01))) + 1.0)), (Int (((Float (local0 * local1)) + arg2) + 1.0)), local2, $00, $00, 1.0)
                color(local3, local4, local5)
            EndIf
            aatext((Int (((arg3 / 2.0) + arg1) - (Float (aastringwidth(local2) Sar $01)))), (Int ((Float (local0 * local1)) + arg2)), local2, $00, $00, 1.0)
        Else
            If (arg7 <> 0) Then
                local3 = colorred()
                local4 = colorgreen()
                local5 = colorblue()
                color($00, $00, $00)
                aatext((Int (arg1 + 1.0)), (Int (((Float (local0 * local1)) + arg2) + 1.0)), local2, $00, $00, 1.0)
                color(local3, local4, local5)
            EndIf
            aatext((Int arg1), (Int ((Float (local0 * local1)) + arg2)), local2, $00, $00, 1.0)
        EndIf
    EndIf
    Return $00
End Function
