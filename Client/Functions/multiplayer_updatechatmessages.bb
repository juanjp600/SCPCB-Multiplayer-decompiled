Function multiplayer_updatechatmessages%()
    Local local0%
    Local local1$
    Local local2%
    Local local3.chatmessage
    Local local4#
    Local local5%
    Local local6%
    Local local7%
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    Local local16%
    Local local17%
    Local local19%
    Local local20%
    Local local21#
    Local local22$
    Local local24.ui_layer
    setfontex(fonts[$00]\Field0)
    setfont(fonts[$00]\Field0)
    lastfont = fonts[$00]\Field0
    local0 = $00
    local2 = $00
    For local3 = Each chatmessage
        local4 = local3\Field2
        local3\Field2 = max((local3\Field2 - fpsfactor), 0.0)
        If (local4 <> local3\Field2) Then
            ui_setupdate($01, $01)
        EndIf
    Next
    If (networkserver\Field19 <> 0) Then
        local5 = $00
        local6 = imenuscale[$28]
        local7 = imenuscale[$28]
        Select chatedittype
            Case $01
                local9 = ((mouseposx - chatwidth) - imenuscale[$0A])
                local10 = (mouseposy - imenuscale[$23])
                chatoffsetx = (Int max((Float local6), min((Float local9), (Float ((graphicwidth - chatwidth) - local6)))))
                chatoffsety = (Int max((Float local7), min((Float local10), (Float ((graphicheight - chatheight) - local7)))))
                local2 = $01
                If (mousehit1 <> 0) Then
                    local5 = $01
                EndIf
            Case $02
                chatwidth = (Int min(max((Float imenuscale[$50]), (Float ((mouseposx - chatoffsetx) - imenuscale[$0A]))), (Float ((graphicwidth - chatoffsetx) - local6))))
                chatheight = (Int min(max((Float imenuscale[$50]), (Float ((mouseposy - chatoffsety) - imenuscale[$1E]))), (Float ((graphicheight - chatoffsety) - local7))))
                local2 = $01
                If (mousehit1 <> 0) Then
                    local5 = $01
                EndIf
        End Select
        If (local5 = $01) Then
            chatedittype = $00
            local0 = $01
            savemultiplayeroptions()
        EndIf
    Else
        chatedittype = $00
    EndIf
    local11 = chatoffsetx
    local12 = chatoffsety
    local13 = chatwidth
    local14 = chatheight
    local15 = (local14 Sar $01)
    If (ui_getcanvas($01) = $00) Then
        If (local13 <= $00) Then
            local13 = imenuscale[$50]
        EndIf
        If (local14 <= $00) Then
            local14 = imenuscale[$50]
        EndIf
        ui_register($01, local11, local12, local13, local14, $01)
    ElseIf (local2 <> 0) Then
        ui_register($01, local11, local12, local13, local14, $01)
    EndIf
    local16 = (imenuscale[$1E] + (imenuscale[$1E] * chatmsgcount))
    local17 = (Int (((Float local14) / (Float local16)) * (Float local14)))
    If (local17 > local14) Then
        local17 = local14
    EndIf
    If (local16 < local14) Then
        local16 = local14
    EndIf
    If (networkserver\Field19 <> 0) Then
        Select chattypes
            Case $01
                drawframe(local11, local12, local13, $01, $00, $00)
                drawframe(local11, local12, $01, local14, $00, $00)
            Case $00
                drawframe(local11, local12, local13, $01, $00, $00)
                drawframe(local11, local12, $01, local14, $00, $00)
                setcolorraw($10101)
                rect((local11 + $01), (local12 + $01), (local13 - $02), (local14 - $02), $01)
        End Select
        setcolorraw($323232)
        local19 = mouseon(((local11 + local13) - imenuscale[$1A]), local12, imenuscale[$1A], local14)
        If (local19 <> 0) Then
            setcolorraw($464646)
        EndIf
        rect(((local11 + local13) - imenuscale[$1A]), local12, imenuscale[$1A], local14, $01)
        setcolorraw($787878)
        local20 = mouseon(((local11 + local13) - imenuscale[$17]), (((local12 + local14) - local17) + ((chatscroll * local17) / local14)), imenuscale[$14], local17)
        If (local20 <> 0) Then
            setcolorraw($C8C8C8)
        EndIf
        If (chatscrolldragging <> 0) Then
            setcolorraw($FFFFFF)
        EndIf
        rect(((local11 + local13) - imenuscale[$17]), (((local12 + local14) - local17) + ((chatscroll * local17) / local14)), imenuscale[$14], local17, $01)
        If (mousedown($01) = $00) Then
            chatscrolldragging = $00
        ElseIf (chatscrolldragging <> 0) Then
            chatscroll = (chatscroll + (((mouseposy - chatmousemem) * local14) / local17))
            chatmousemem = mouseposy
            ui_setupdate($01, $01)
        EndIf
        If (chatscrolldragging = $00) Then
            If (mousehit1 <> 0) Then
                If (local20 <> 0) Then
                    chatscrolldragging = $01
                    chatmousemem = mouseposy
                ElseIf (local19 <> 0) Then
                    chatscroll = (chatscroll + ((((mouseposy - (local12 + local14)) * local16) / local14) + local15))
                    chatscroll = (chatscroll Sar $01)
                    ui_setupdate($01, $01)
                EndIf
            EndIf
        EndIf
        local21 = (Float mousezspeed())
        If (0.0 < local21) Then
            chatscroll = (chatscroll - imenuscale[$0F])
            ui_setupdate($01, $01)
        ElseIf (0.0 > local21) Then
            chatscroll = (chatscroll + imenuscale[$0F])
            ui_setupdate($01, $01)
        EndIf
        If (chatscroll < ((- local16) + local14)) Then
            chatscroll = ((- local16) + local14)
            ui_setupdate($01, $01)
        EndIf
        If (chatscroll > $00) Then
            chatscroll = $00
            ui_setupdate($01, $01)
        EndIf
        setcolorraw($FFFFFF)
        selectedinputbox = $539
        typedchatmsg = inputbox(local11, (local12 + local14), local13, imenuscale[$23], typedchatmsg, $539, $01, (Float (chatwidth - imenuscale[$37])))
        If (left(typedchatmsg, $64) <> typedchatmsg) Then
            ui_setupdate($01, $01)
        EndIf
        typedchatmsg = left(typedchatmsg, $64)
        If (mouseon(((local11 + local13) - imenuscale[$1E]), ((local12 + local14) + imenuscale[$08]), imenuscale[$14], imenuscale[$14]) <> 0) Then
            drawimage(mpimg\Field11, ((local11 + local13) - imenuscale[$1E]), ((local12 + local14) + imenuscale[$08]), $00)
            drawtextrect((mouseposx - imenuscale[$0F]), (mouseposy - imenuscale[$14]), $00, $00, "Soon...")
        Else
            drawimage(mpimg\Field10, ((local11 + local13) - imenuscale[$1E]), ((local12 + local14) + imenuscale[$08]), $00)
        EndIf
        If (typedchatmsg = "") Then
            local1 = "Type message"
            If (stringwidth(local1) > (chatwidth - imenuscale[$37])) Then
                local1 = left(local1, (Int max(0.0, (Float (((chatwidth - imenuscale[$37]) / stringwidth("W")) - $03)))))
                local1 = (local1 + "...")
            EndIf
            text((Int ((10.0 * menuscale) + (Float local11))), (Int ((10.0 * menuscale) + (Float (local12 + local14)))), local1, $00, $00)
        EndIf
        If (keyhit($1C) <> 0) Then
            If (getscripts() <> 0) Then
                public_inqueue($12, $00)
                public_addparam(typedchatmsg, $03)
                callback()
            EndIf
            If (((isacommand(typedchatmsg) = $00) And (typedchatmsg <> "")) <> 0) Then
                multiplayer_addchatmsg((": " + typedchatmsg), $01)
                chatscroll = $00
            EndIf
            networkserver\Field19 = $00
            typedchatmsg = ""
            selectedinputbox = $00
            ui_setupdate($01, $01)
            flushkeys()
            flushmouse()
        EndIf
        If (drawbutton((local11 + local13), local12, imenuscale[$19], imenuscale[$19], "X", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FF, $00, $00, $00) <> 0) Then
            networkserver\Field19 = $00
            typedchatmsg = ""
            selectedinputbox = $00
            ui_setupdate($01, $01)
            flushkeys()
            flushmouse()
        EndIf
        Select chattypes
            Case $01
                local22 = "+"
            Case $00
                local22 = "-"
        End Select
        If (drawbutton((local11 + local13), (imenuscale[$19] + local12), imenuscale[$19], imenuscale[$19], "P", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
            If (local0 = $00) Then
                If (chatedittype <> $00) Then
                    chatedittype = $00
                    savemultiplayeroptions()
                Else
                    chatedittype = $01
                EndIf
                ui_setupdate($01, $01)
            EndIf
        EndIf
        If (drawbutton((local11 + local13), (imenuscale[$32] + local12), imenuscale[$19], imenuscale[$19], "S", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
            If (local0 = $00) Then
                If (chatedittype <> $00) Then
                    chatedittype = $00
                    savemultiplayeroptions()
                Else
                    chatedittype = $02
                EndIf
                ui_setupdate($01, $01)
            EndIf
        EndIf
        If (drawbutton((local11 + local13), (imenuscale[$4B] + local12), imenuscale[$19], imenuscale[$19], local22, $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
            chattypes = (chattypes = $00)
            savemultiplayeroptions()
            ui_setupdate($01, $01)
        EndIf
    EndIf
    If (networkserver\Field19 <> 0) Then
        ui_setupdate($01, $01)
    EndIf
    local24 = (Object.ui_layer ui_layer[$01])
    If (local24 <> Null) Then
        local24\Field2 = chatoffsetx
        local24\Field3 = chatoffsety
    EndIf
    ui_renderblock($01, $00)
    setcolorraw($FFFFFF)
    setfontex(fonts[$00]\Field0)
    If (networkserver\Field19 <> 0) Then
        ui_showpointer()
    EndIf
    Return $00
End Function
