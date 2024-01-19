Function multiplayer_updatechatmessages%()
    Local local0%
    Local local1$
    Local local3#
    Local local4#
    Local local5#
    Local local6#
    Local local7%
    Local local8%
    Local local9.chatmessage
    Local local11%
    Local local12%
    Local local13#
    Local local14$
    Local local16%
    Local local17%
    Local local18#
    aasetfont(font1)
    local0 = $00
    If (networkserver\Field27 <> 0) Then
        Select chatedittype
            Case $01
                chatoffsetx = (((Float scaledmousex()) - chatwidth) - (10.0 * menuscale))
                chatoffsety = ((Float scaledmousey()) - (35.0 * menuscale))
            Case $02
                chatwidth = min(max((80.0 * menuscale), (((Float scaledmousex()) - chatoffsetx) - (10.0 * menuscale))), (((Float graphicwidth) - chatoffsetx) - (30.0 * menuscale)))
                chatheight = max((80.0 * menuscale), ((Float scaledmousey()) - chatoffsety))
                If (mousehit1 <> 0) Then
                    chatedittype = $00
                    local0 = $01
                    savemultiplayeroptions()
                EndIf
        End Select
    Else
        chatedittype = $00
    EndIf
    local3 = chatoffsetx
    local4 = chatoffsety
    local5 = chatwidth
    local6 = chatheight
    local7 = (Int (30.0 * menuscale))
    local8 = $00
    For local9 = Each chatmessage
        local7 = (Int ((30.0 * menuscale) + (Float local7)))
    Next
    local8 = (Int ((local6 / (Float local7)) * local6))
    If (local6 < (Float local8)) Then
        local8 = (Int local6)
    EndIf
    If (local6 > (Float local7)) Then
        local7 = (Int local6)
    EndIf
    If (networkserver\Field27 <> 0) Then
        Select chattypes
            Case $01
                drawframe((Int local3), (Int local4), (Int local5), $01, $00, $00)
                drawframe((Int local3), (Int local4), $01, (Int local6), $00, $00)
            Case $00
                drawframe((Int local3), (Int local4), (Int local5), $01, $00, $00)
                drawframe((Int local3), (Int local4), $01, (Int local6), $00, $00)
                color($01, $01, $01)
                rect((Int (local3 + 1.0)), (Int (local4 + 1.0)), (Int (local5 - 1.0)), (Int (local6 - 1.0)), $01)
        End Select
        color($32, $32, $32)
        local11 = mouseon((Int ((local3 + local5) - (26.0 * menuscale))), (Int local4), (Int (26.0 * menuscale)), (Int local6))
        If (local11 <> 0) Then
            color($46, $46, $46)
        EndIf
        rect((Int ((local3 + local5) - (26.0 * menuscale))), (Int local4), (Int (26.0 * menuscale)), (Int local6), $01)
        color($78, $78, $78)
        local12 = mouseon((Int ((local3 + local5) - (23.0 * menuscale))), (Int (((local4 + local6) - (Float local8)) + ((chatscroll * (Float local8)) / local6))), (Int (20.0 * menuscale)), local8)
        If (local12 <> 0) Then
            color($C8, $C8, $C8)
        EndIf
        If (chatscrolldragging <> 0) Then
            color($FF, $FF, $FF)
        EndIf
        rect((Int ((local3 + local5) - (23.0 * menuscale))), (Int (((local4 + local6) - (Float local8)) + ((chatscroll * (Float local8)) / local6))), (Int (20.0 * menuscale)), local8, $01)
        If (mousedown($01) = $00) Then
            chatscrolldragging = $00
        ElseIf (chatscrolldragging <> 0) Then
            chatscroll = (((((Float scaledmousey()) - chatmousemem) * local6) / (Float local8)) + chatscroll)
            chatmousemem = (Float scaledmousey())
        EndIf
        If (chatscrolldragging = $00) Then
            If (mousehit1 <> 0) Then
                If (local12 <> 0) Then
                    chatscrolldragging = $01
                    chatmousemem = (Float scaledmousey())
                ElseIf (local11 <> 0) Then
                    chatscroll = ((((((Float scaledmousey()) - (local4 + local6)) * (Float local7)) / local6) + (local6 / 2.0)) + chatscroll)
                    chatscroll = (chatscroll / 2.0)
                EndIf
            EndIf
        EndIf
        local13 = (Float mousezspeed())
        If (0.0 < local13) Then
            chatscroll = (chatscroll - (15.0 * menuscale))
        ElseIf (0.0 > local13) Then
            chatscroll = ((15.0 * menuscale) + chatscroll)
        EndIf
        If (chatscroll < ((Float (- local7)) + local6)) Then
            chatscroll = ((Float (- local7)) + local6)
        EndIf
        If (0.0 < chatscroll) Then
            chatscroll = 0.0
        EndIf
        color($FF, $FF, $FF)
        selectedinputbox = $539
        typedchatmsg = inputbox((Int local3), (Int (local4 + local6)), (Int local5), (Int (35.0 * menuscale)), typedchatmsg, $539, $01, (chatwidth - (55.0 * menuscale)))
        typedchatmsg = left(typedchatmsg, $64)
        If (mouseon((Int ((local3 + local5) - (30.0 * menuscale))), (Int ((local4 + local6) + (8.0 * menuscale))), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
            drawimage(mpimg\Field13, (Int ((local3 + local5) - (30.0 * menuscale))), (Int ((local4 + local6) + (8.0 * menuscale))), $00)
            drawtextrect((Int ((Float scaledmousex()) - (15.0 * menuscale))), (Int ((Float scaledmousey()) - (20.0 * menuscale))), $00, $00, "Soon...")
        Else
            drawimage(mpimg\Field12, (Int ((local3 + local5) - (30.0 * menuscale))), (Int ((local4 + local6) + (8.0 * menuscale))), $00)
        EndIf
        If (typedchatmsg = "") Then
            local1 = "Type message"
            If ((Float aastringwidth(local1)) > (chatwidth - (55.0 * menuscale))) Then
                local1 = left(local1, (Int max(0.0, (((chatwidth - (55.0 * menuscale)) / (Float aastringwidth("W"))) - 3.0))))
                local1 = (local1 + "...")
            EndIf
            aatext((Int ((10.0 * menuscale) + local3)), (Int ((local4 + local6) + (10.0 * menuscale))), local1, $00, $00, 1.0)
        EndIf
        If (keyhit($1C) <> 0) Then
            If (getscripts() <> 0) Then
                public_inqueue($12, $00)
                public_addparam(typedchatmsg, $03)
                callback()
            EndIf
            If (((isacommand(typedchatmsg) = $00) And (typedchatmsg <> "")) <> 0) Then
                multiplayer_addchatmsg((": " + typedchatmsg), $01)
                chatscroll = 0.0
            EndIf
            networkserver\Field27 = $00
            typedchatmsg = ""
            selectedinputbox = $00
            flushkeys()
            flushmouse()
        EndIf
        If (drawbutton((Int (local3 + local5)), (Int local4), (Int (25.0 * menuscale)), (Int (25.0 * menuscale)), "X", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FF, $00, $00, $00) <> 0) Then
            networkserver\Field27 = $00
            typedchatmsg = ""
            selectedinputbox = $00
            flushkeys()
            flushmouse()
        EndIf
        Select chattypes
            Case $01
                local14 = "+"
            Case $00
                local14 = "-"
        End Select
        If (drawbutton((Int (local3 + local5)), (Int ((25.0 * menuscale) + local4)), (Int (25.0 * menuscale)), (Int (25.0 * menuscale)), "P", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
            If (local0 = $00) Then
                If (chatedittype <> $00) Then
                    chatedittype = $00
                    savemultiplayeroptions()
                Else
                    chatedittype = $01
                EndIf
            EndIf
        EndIf
        If (drawbutton((Int (local3 + local5)), (Int ((50.0 * menuscale) + local4)), (Int (25.0 * menuscale)), (Int (25.0 * menuscale)), "S", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
            If (local0 = $00) Then
                If (chatedittype <> $00) Then
                    chatedittype = $00
                    savemultiplayeroptions()
                Else
                    chatedittype = $02
                EndIf
            EndIf
        EndIf
        If (drawbutton((Int (local3 + local5)), (Int ((75.0 * menuscale) + local4)), (Int (25.0 * menuscale)), (Int (25.0 * menuscale)), local14, $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
            chattypes = (chattypes = $00)
            savemultiplayeroptions()
        EndIf
    EndIf
    local16 = (Int (((local4 + local6) - (25.0 * menuscale)) - chatscroll))
    local17 = $00
    color($FF, $FF, $FF)
    disableredirectaccess = $01
    For local9 = Each chatmessage
        local17 = (local17 + $01)
        If (local17 > $12C) Then
            local17 = $00
            For local9 = Each chatmessage
                Delete local9
                local17 = (local17 + $01)
                If (local17 > $96) Then
                    Exit
                EndIf
            Next
            Exit
        Else
            local9\Field2 = max((local9\Field2 - fpsfactor), 0.0)
            If (local4 <= (Float local16)) Then
                If ((Float local16) < ((local4 + local6) - (5.0 * menuscale))) Then
                    local18 = 1.0
                    If (networkserver\Field27 = $00) Then
                        local18 = (min((local9\Field2 / 2.0), 255.0) / 255.0)
                    EndIf
                    If (0.0 < local18) Then
                        color((Int (255.0 * local18)), (Int (255.0 * local18)), (Int (255.0 * local18)))
                        If (local9\Field4 <> 0) Then
                            limitformattext(((5.0 * menuscale) + local3), (Float local16), local9\Field0, (chatwidth - (30.0 * menuscale)), $00, $00, local18, ((chattypes = $01) Or (networkserver\Field27 = $00)))
                        Else
                            limittext(local9\Field0, (Int ((5.0 * menuscale) + local3)), local16, (Int (chatwidth - (30.0 * menuscale))), $01, ((chattypes = $01) Or (networkserver\Field27 = $00)))
                        EndIf
                    EndIf
                EndIf
            EndIf
            local16 = (Int ((Float local16) - (30.0 * menuscale)))
        EndIf
    Next
    disableredirectaccess = $00
    color($FF, $FF, $FF)
    aasetfont(font1)
    If (networkserver\Field27 <> 0) Then
        If (fullscreen <> 0) Then
            drawimage(cursorimg, scaledmousex(), scaledmousey(), $00)
        EndIf
    EndIf
    Return $00
End Function
