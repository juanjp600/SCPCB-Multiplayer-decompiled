Function updateconsole%()
    Local local0.consolemsg
    Local local1%
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
    If (canopenconsole = $00) Then
        consoleopen = $00
        Return $00
    EndIf
    If (consoleopen <> 0) Then
        ui_setupdate($00, $01)
        setfontex(fonts[$05]\Field0)
        local1 = $00
        local2 = (graphicheight - imenuscale[$14A])
        local3 = graphicwidth
        local4 = imenuscale[$12C]
        local5 = imenuscale[$87]
        drawframe(local1, local2, local3, (imenuscale[$1E] + local4), $00, $00)
        local13 = (Int (((Float local4) / (Float consolefullheight)) * (Float local4)))
        If (local13 > local4) Then
            local13 = local4
        EndIf
        local9 = ((local1 + local3) - imenuscale[$1A])
        local11 = imenuscale[$1A]
        local12 = local4
        setcolorex($32, $32, $32)
        local14 = mouseon(local9, local2, local11, local12)
        If (local14 <> 0) Then
            setcolorex($46, $46, $46)
        EndIf
        rect(local9, local2, local11, local12, $01)
        local9 = ((local1 + local3) - imenuscale[$17])
        local10 = (((local2 + local4) - local13) + ((consolescroll * local13) / local4))
        local11 = imenuscale[$14]
        local12 = local13
        setcolorex($64, $64, $64)
        local15 = mouseon(local9, local10, local11, local12)
        If (local15 <> 0) Then
            setcolorex($96, $96, $96)
        EndIf
        If (consolescrolldragging <> 0) Then
            setcolorex($FF, $FF, $FF)
        EndIf
        rect(local9, local10, local11, local12, $01)
        If (mousedown($01) = $00) Then
            consolescrolldragging = $00
        ElseIf (consolescrolldragging <> 0) Then
            consolescroll = (consolescroll + (((mouseposy - consolemousemem) * local4) / local13))
            consolemousemem = mouseposy
        EndIf
        If (consolescrolldragging = $00) Then
            If (mousehit1 <> 0) Then
                If (local15 <> 0) Then
                    consolescrolldragging = $01
                    consolemousemem = mouseposy
                ElseIf (local14 <> 0) Then
                    consolescroll = (consolescroll + (((mouseposy - (local2 + local4)) * consolefullheight) / (local4 + local5)))
                    consolescroll = (consolescroll Sar $01)
                EndIf
            EndIf
        EndIf
        local16 = mousezspeed()
        If (local16 = $01) Then
            consolescroll = (consolescroll - imenuscale[$0F])
        ElseIf (local16 = $FFFFFFFF) Then
            consolescroll = (consolescroll + imenuscale[$0F])
        EndIf
        If (keyhit($C8) <> 0) Then
            local17 = $00
            If (consolereissue = Null) Then
                consolereissue = (First consolemsg)
                While (consolereissue <> Null)
                    If (consolereissue\Field1 <> 0) Then
                        Exit
                    EndIf
                    local17 = (local17 - imenuscale[$0F])
                    consolereissue = (After consolereissue)
                Wend
            Else
                local0 = (First consolemsg)
                While (local0 <> Null)
                    If (local0 = consolereissue) Then
                        Exit
                    EndIf
                    local17 = (local17 - imenuscale[$0F])
                    local0 = (After local0)
                Wend
                consolereissue = (After consolereissue)
                local17 = (local17 - imenuscale[$0F])
                Repeat
                    If (consolereissue = Null) Then
                        consolereissue = (First consolemsg)
                        local17 = $00
                    EndIf
                    If (consolereissue\Field1 <> 0) Then
                        Exit
                    EndIf
                    local17 = (local17 - imenuscale[$0F])
                    consolereissue = (After consolereissue)
                Forever
            EndIf
            If (consolereissue <> Null) Then
                consoleinput = consolereissue\Field0
                consolescroll = (local17 + local5)
            EndIf
        EndIf
        If (keyhit($D0) <> 0) Then
            local17 = ((- consolefullheight) + imenuscale[$0F])
            If (consolereissue = Null) Then
                consolereissue = (Last consolemsg)
                While (consolereissue <> Null)
                    If (consolereissue\Field1 <> 0) Then
                        Exit
                    EndIf
                    local17 = (local17 + imenuscale[$0F])
                    consolereissue = (Before consolereissue)
                Wend
            Else
                local0 = (Last consolemsg)
                While (local0 <> Null)
                    If (local0 = consolereissue) Then
                        Exit
                    EndIf
                    local17 = (local17 + imenuscale[$0F])
                    local0 = (Before local0)
                Wend
                consolereissue = (Before consolereissue)
                local17 = (local17 + imenuscale[$0F])
                Repeat
                    If (consolereissue = Null) Then
                        consolereissue = (Last consolemsg)
                        local17 = ((- consolefullheight) + imenuscale[$0F])
                    EndIf
                    If (consolereissue\Field1 <> 0) Then
                        Exit
                    EndIf
                    local17 = (local17 + imenuscale[$0F])
                    consolereissue = (Before consolereissue)
                Forever
            EndIf
            If (consolereissue <> Null) Then
                consoleinput = consolereissue\Field0
                consolescroll = (local17 + local5)
            EndIf
        EndIf
        If (consolescroll < ((- consolefullheight) + local4)) Then
            consolescroll = ((- consolefullheight) + local4)
        EndIf
        If (consolescroll > $00) Then
            consolescroll = $00
        EndIf
        setcolorex($FF, $FF, $FF)
        selectedinputbox = $02
        local18 = consoleinput
        consoleinput = inputbox(local1, (local2 + local4), local3, imenuscale[$1E], consoleinput, $02, $00, -1.0)
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
            consolescroll = $00
            createconsolemsg(consoleinput, $FF, $FF, $00, $01)
            executeconsolecommand(consoleinput, $01, $01)
            consoleinput = ""
        EndIf
        ui_renderblock($00, consolescroll)
        ui_showpointer()
    EndIf
    Return $00
End Function
