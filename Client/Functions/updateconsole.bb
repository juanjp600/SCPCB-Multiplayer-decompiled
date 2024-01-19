Function updateconsole%()
    Local local0%
    Local local1.consolemsg
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6$
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    Local local16%
    Local local17%
    Local local18$
    Local local19%
    Local local20%
    If (canopenconsole = $00) Then
        consoleopen = $00
        Return $00
    EndIf
    If (consoleopen <> 0) Then
        aasetfont(consolefont)
        consoler = $FF
        consoleg = $FF
        consoleb = $FF
        local2 = $00
        local3 = (Int ((Float graphicheight) - (300.0 * menuscale)))
        local4 = graphicwidth
        local5 = (Int ((300.0 * menuscale) - (30.0 * menuscale)))
        drawframe(local2, local3, local4, (Int ((30.0 * menuscale) + (Float local5))), $00, $00)
        local12 = $00
        local13 = $00
        For local1 = Each consolemsg
            local12 = (Int ((15.0 * menuscale) + (Float local12)))
        Next
        local13 = (Int (((Float local5) / (Float local12)) * (Float local5)))
        If (local13 > local5) Then
            local13 = local5
        EndIf
        If (local12 < local5) Then
            local12 = local5
        EndIf
        color($32, $32, $32)
        local14 = mouseon((Int ((Float (local2 + local4)) - (26.0 * menuscale))), local3, (Int (26.0 * menuscale)), local5)
        If (local14 <> 0) Then
            color($46, $46, $46)
        EndIf
        rect((Int ((Float (local2 + local4)) - (26.0 * menuscale))), local3, (Int (26.0 * menuscale)), local5, $01)
        color($78, $78, $78)
        local15 = mouseon((Int ((Float (local2 + local4)) - (23.0 * menuscale))), (Int (((consolescroll * (Float local13)) / (Float local5)) + (Float ((local3 + local5) - local13)))), (Int (20.0 * menuscale)), local13)
        If (local15 <> 0) Then
            color($C8, $C8, $C8)
        EndIf
        If (consolescrolldragging <> 0) Then
            color($FF, $FF, $FF)
        EndIf
        rect((Int ((Float (local2 + local4)) - (23.0 * menuscale))), (Int (((consolescroll * (Float local13)) / (Float local5)) + (Float ((local3 + local5) - local13)))), (Int (20.0 * menuscale)), local13, $01)
        If (mousedown($01) = $00) Then
            consolescrolldragging = $00
        ElseIf (consolescrolldragging <> 0) Then
            consolescroll = ((Float (((scaledmousey() - consolemousemem) * local5) / local13)) + consolescroll)
            consolemousemem = scaledmousey()
        EndIf
        If (consolescrolldragging = $00) Then
            If (mousehit1 <> 0) Then
                If (local15 <> 0) Then
                    consolescrolldragging = $01
                    consolemousemem = scaledmousey()
                ElseIf (local14 <> 0) Then
                    consolescroll = ((Float ((((scaledmousey() - (local3 + local5)) * local12) / local5) + (local5 Sar $01))) + consolescroll)
                    consolescroll = (consolescroll / 2.0)
                EndIf
            EndIf
        EndIf
        local16 = mousezspeed()
        If (local16 = $01) Then
            consolescroll = (consolescroll - (15.0 * menuscale))
        ElseIf (local16 = $FFFFFFFF) Then
            consolescroll = ((15.0 * menuscale) + consolescroll)
        EndIf
        If (keyhit($C8) <> 0) Then
            local17 = $00
            If (consolereissue = Null) Then
                consolereissue = (First consolemsg)
                While (consolereissue <> Null)
                    If (consolereissue\Field1 <> 0) Then
                        Exit
                    EndIf
                    local17 = (Int ((Float local17) - (15.0 * menuscale)))
                    consolereissue = (After consolereissue)
                Wend
            Else
                local1 = (First consolemsg)
                While (local1 <> Null)
                    If (local1 = consolereissue) Then
                        Exit
                    EndIf
                    local17 = (Int ((Float local17) - (15.0 * menuscale)))
                    local1 = (After local1)
                Wend
                consolereissue = (After consolereissue)
                local17 = (Int ((Float local17) - (15.0 * menuscale)))
                Repeat
                    If (consolereissue = Null) Then
                        consolereissue = (First consolemsg)
                        local17 = $00
                    EndIf
                    If (consolereissue\Field1 <> 0) Then
                        Exit
                    EndIf
                    local17 = (Int ((Float local17) - (15.0 * menuscale)))
                    consolereissue = (After consolereissue)
                Forever
            EndIf
            If (consolereissue <> Null) Then
                consoleinput = consolereissue\Field0
                consolescroll = (Float ((local5 Sar $01) + local17))
            EndIf
        EndIf
        If (keyhit($D0) <> 0) Then
            local17 = (Int ((15.0 * menuscale) + (Float (- local12))))
            If (consolereissue = Null) Then
                consolereissue = (Last consolemsg)
                While (consolereissue <> Null)
                    If (consolereissue\Field1 <> 0) Then
                        Exit
                    EndIf
                    local17 = (Int ((15.0 * menuscale) + (Float local17)))
                    consolereissue = (Before consolereissue)
                Wend
            Else
                local1 = (Last consolemsg)
                While (local1 <> Null)
                    If (local1 = consolereissue) Then
                        Exit
                    EndIf
                    local17 = (Int ((15.0 * menuscale) + (Float local17)))
                    local1 = (Before local1)
                Wend
                consolereissue = (Before consolereissue)
                local17 = (Int ((15.0 * menuscale) + (Float local17)))
                Repeat
                    If (consolereissue = Null) Then
                        consolereissue = (Last consolemsg)
                        local17 = (Int ((15.0 * menuscale) + (Float (- local12))))
                    EndIf
                    If (consolereissue\Field1 <> 0) Then
                        Exit
                    EndIf
                    local17 = (Int ((15.0 * menuscale) + (Float local17)))
                    consolereissue = (Before consolereissue)
                Forever
            EndIf
            If (consolereissue <> Null) Then
                consoleinput = consolereissue\Field0
                consolescroll = (Float ((local5 Sar $01) + local17))
            EndIf
        EndIf
        If ((Float ((- local12) + local5)) > consolescroll) Then
            consolescroll = (Float ((- local12) + local5))
        EndIf
        If (0.0 < consolescroll) Then
            consolescroll = 0.0
        EndIf
        color($FF, $FF, $FF)
        selectedinputbox = $02
        local18 = consoleinput
        consoleinput = inputbox(local2, (local3 + local5), local4, (Int (30.0 * menuscale)), consoleinput, $02, $00, -1.0)
        If (local18 <> consoleinput) Then
            consolereissue = Null
        EndIf
        consoleinput = left(consoleinput, $64)
        If ((keyhit($1C) And (consoleinput <> "")) <> 0) Then
            If (getscripts() <> 0) Then
                public_inqueue($0A, $00)
                public_addparam(consoleinput, $03)
                callback()
            EndIf
            consolereissue = Null
            consolescroll = 0.0
            createconsolemsg(consoleinput, $FF, $FF, $00, $01)
            executeconsolecommand(consoleinput, $01, $01)
            consoleinput = ""
        EndIf
        local19 = (Int (((Float (local3 + local5)) - (25.0 * menuscale)) - consolescroll))
        local20 = $00
        For local1 = Each consolemsg
            local20 = (local20 + $01)
            If (local20 > $3E8) Then
                Delete local1
            Else
                If (((local19 >= local3) And ((Float local19) < ((Float (local3 + local5)) - (20.0 * menuscale)))) <> 0) Then
                    If (local1 = consolereissue) Then
                        color((local1\Field2 Sar $02), (local1\Field3 Sar $02), (local1\Field4 Sar $02))
                        rect(local2, (Int ((Float local19) - (2.0 * menuscale))), (Int ((Float local4) - (30.0 * menuscale))), (Int (24.0 * menuscale)), $01)
                    EndIf
                    color(local1\Field2, local1\Field3, local1\Field4)
                    If (local1\Field1 <> 0) Then
                        aatext((Int ((20.0 * menuscale) + (Float local2))), local19, ("> " + local1\Field0), $00, $00, 1.0)
                    Else
                        aatext((Int ((20.0 * menuscale) + (Float local2))), local19, local1\Field0, $00, $00, 1.0)
                    EndIf
                EndIf
                local19 = (Int ((Float local19) - (15.0 * menuscale)))
            EndIf
        Next
        color($FF, $FF, $FF)
        If (fullscreen <> 0) Then
            drawimage(cursorimg, scaledmousex(), scaledmousey(), $00)
        EndIf
    EndIf
    aasetfont(font1)
    Return $00
End Function
