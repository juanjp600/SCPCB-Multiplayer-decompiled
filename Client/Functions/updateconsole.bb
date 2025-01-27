Function updateconsole%()
    Local local0.consolemsg
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10$
    Local local11%
    catcherrors("UpdateConsole()")
    If (opt\Field31 = $00) Then
        consoleopen = $00
        Return $00
    EndIf
    If (consoleopen <> 0) Then
        local1 = (Int (15.0 * menuscale))
        consoler = $FF
        consoleg = $FF
        consoleb = $FF
        local2 = $00
        local3 = (Int ((Float opt\Field50) - (300.0 * menuscale)))
        local4 = opt\Field49
        local5 = (Int (270.0 * menuscale))
        local6 = (local5 Sar $01)
        local7 = $00
        local8 = $00
        For local0 = Each consolemsg
            local7 = (local7 + local1)
        Next
        local8 = (Int (((Float local5) / (Float local7)) * (Float local5)))
        local8 = (Int min((Float local8), (Float local5)))
        local7 = (Int max((Float local7), (Float local5)))
        consoleinbar = mouseon((Int ((Float (local2 + local4)) - (26.0 * menuscale))), local3, (Int (26.0 * menuscale)), local5)
        consoleinbox = mouseon((Int ((Float (local2 + local4)) - (23.0 * menuscale))), (Int (((consolescroll * (Float local8)) / (Float local5)) + (Float ((local3 + local5) - local8)))), (Int (20.0 * menuscale)), local8)
        If (mo\Field2 = $00) Then
            consolescrolldragging = $00
        ElseIf (consolescrolldragging <> 0) Then
            consolescroll = ((((mouseposy - (Float consolemousemem)) * (Float local5)) / (Float local8)) + consolescroll)
            consolemousemem = (Int mouseposy)
        EndIf
        If (consolescrolldragging = $00) Then
            If (mo\Field0 <> 0) Then
                If (consoleinbox <> 0) Then
                    consolescrolldragging = $01
                    consolemousemem = (Int mouseposy)
                ElseIf (consoleinbar <> 0) Then
                    consolescroll = (((((mouseposy - (Float (local3 + local5))) * (Float local7)) / (Float local5)) + (Float local6)) + consolescroll)
                    consolescroll = (consolescroll / 2.0)
                EndIf
            EndIf
        EndIf
        consolescroll = (consolescroll + (Float ((- mousezspeed()) * local1)))
        If (keyhit($C8) <> 0) Then
            local9 = $00
            If (consolereissue = Null) Then
                consolereissue = (First consolemsg)
                While (consolereissue <> Null)
                    If (consolereissue\Field1 <> 0) Then
                        Exit
                    EndIf
                    local9 = (local9 - local1)
                    consolereissue = (After consolereissue)
                Wend
            Else
                local0 = (First consolemsg)
                While (local0 <> Null)
                    If (local0 = consolereissue) Then
                        Exit
                    EndIf
                    local9 = (local9 - local1)
                    local0 = (After local0)
                Wend
                consolereissue = (After consolereissue)
                local9 = (local9 - local1)
                Repeat
                    If (consolereissue = Null) Then
                        consolereissue = (First consolemsg)
                        local9 = $00
                    EndIf
                    If (consolereissue\Field1 <> 0) Then
                        Exit
                    EndIf
                    local9 = (local9 - local1)
                    consolereissue = (After consolereissue)
                Forever
            EndIf
            If (consolereissue <> Null) Then
                consoleinput = consolereissue\Field0
                consolescroll = (Float (local9 + local6))
            EndIf
        EndIf
        If (keyhit($D0) <> 0) Then
            local9 = ((- local7) + local1)
            If (consolereissue = Null) Then
                consolereissue = (Last consolemsg)
                While (consolereissue <> Null)
                    If (consolereissue\Field1 <> 0) Then
                        Exit
                    EndIf
                    local9 = (local9 + local1)
                    consolereissue = (Before consolereissue)
                Wend
            Else
                local0 = (Last consolemsg)
                While (local0 <> Null)
                    If (local0 = consolereissue) Then
                        Exit
                    EndIf
                    local9 = (local9 + local1)
                    local0 = (Before local0)
                Wend
                consolereissue = (Before consolereissue)
                local9 = (local9 + local1)
                Repeat
                    If (consolereissue = Null) Then
                        consolereissue = (Last consolemsg)
                        local9 = ((- local7) + local1)
                    EndIf
                    If (consolereissue\Field1 <> 0) Then
                        Exit
                    EndIf
                    local9 = (local9 + local1)
                    consolereissue = (Before consolereissue)
                Forever
            EndIf
            If (consolereissue <> Null) Then
                consoleinput = consolereissue\Field0
                consolescroll = (Float (local9 + local6))
            EndIf
        EndIf
        consolescroll = clamp(consolescroll, (Float ((- local7) + local5)), 0.0)
        selectedinputbox = $13
        local10 = consoleinput
        consoleinput = updatemenuinputbox(local2, (local3 + local5), local4, (Int (30.0 * menuscale)), consoleinput, $05, $13, $00, 1.0)
        If (local10 <> consoleinput) Then
            consolereissue = Null
        EndIf
        consoleinput = left(consoleinput, $64)
        If ((keyhit($1C) And (consoleinput <> "")) <> 0) Then
            consolereissue = Null
            consolescroll = 0.0
            createconsolemsg(consoleinput, $FF, $FF, $00, $01)
            mp_client_executeconsolecommand(consoleinput)
            executeconsolecommand(consoleinput)
            consoleinput = ""
        EndIf
        local11 = $00
        For local0 = Each consolemsg
            local11 = (local11 + $01)
            If (local11 > $3E8) Then
                Delete local0
            EndIf
        Next
    EndIf
    catcherrors("Uncaught: UpdateConsole()")
    Return $00
End Function
