Function render3d%(arg0#)
    Local local0%
    Local local1%
    Local local2%
    Local local3.npcs
    Local local4%
    Local local5%
    Local local6%
    Local local7#
    Local local8#
    Local local9#
    Local local10#
    Local local11#
    Local local12%
    Local local13%
    cameraprojmode(ark_blur_cam, $00)
    cameraprojmode(camera, $01)
    If (((wearingnightvision > $00) And (wearingnightvision < $03)) <> 0) Then
        ambientlight(min((Float (brightness Shl $01)), 255.0), min((Float (brightness Shl $01)), 255.0), min((Float (brightness Shl $01)), 255.0))
    ElseIf (wearingnightvision = $03) Then
        ambientlight(255.0, 255.0, 255.0)
    ElseIf (playerroom <> Null) Then
        If ((((playerroom\Field7\Field11 <> "173") And (playerroom\Field7\Field11 <> "exit1")) And (playerroom\Field7\Field11 <> "gatea")) <> 0) Then
            ambientlight((Float brightness), (Float brightness), (Float brightness))
        EndIf
    EndIf
    isnvgblinking = $00
    hideentity(nvblink)
    cameraviewport(camera, $00, $00, graphicwidth, graphicheight)
    If (getscripts() <> 0) Then
        public_inqueue($07, $01)
    EndIf
    local0 = $02
    local1 = $00
    If (((wearingnightvision = $01) Or (wearingnightvision = $02)) <> 0) Then
        For local2 = $00 To $09 Step $01
            If (inventory(local2) <> Null) Then
                If ((((wearingnightvision = $01) And (inventory(local2)\Field3\Field2 = "nvgoggles")) Or ((wearingnightvision = $02) And (inventory(local2)\Field3\Field2 = "supernv"))) <> 0) Then
                    inventory(local2)\Field13 = (inventory(local2)\Field13 - ((0.02 * (Float wearingnightvision)) * fpsfactor))
                    local1 = (Int inventory(local2)\Field13)
                    local0 = $01
                EndIf
            EndIf
        Next
        If (local0 <> 0) Then
            renderworld(arg0)
        EndIf
    Else
        renderworld(arg0)
    EndIf
    currtrisamount = trisrendered()
    If (((local0 = $00) And (wearingnightvision <> $03)) <> 0) Then
        isnvgblinking = $01
        showentity(nvblink)
    EndIf
    If (((-16.0 > blinktimer) Or (-6.0 < blinktimer)) <> 0) Then
        If (((wearingnightvision = $02) And (local0 <> $00)) <> 0) Then
            nvtimer = (nvtimer - fpsfactor)
            If (0.0 >= nvtimer) Then
                For local3 = Each npcs
                    local3\Field40 = entityx(local3\Field4, $01)
                    local3\Field41 = entityy(local3\Field4, $01)
                    local3\Field42 = entityz(local3\Field4, $01)
                Next
                isnvgblinking = $01
                showentity(nvblink)
                If (-10.0 >= nvtimer) Then
                    nvtimer = 600.0
                EndIf
            EndIf
            color($FF, $FF, $FF)
            aasetfont(font3)
            local4 = $00
            If (local0 = $01) Then
                local4 = $28
            EndIf
            aatext((graphicwidth Sar $01), (Int ((Float ($14 + local4)) * menuscale)), "REFRESHING DATA IN", $01, $00, 1.0)
            aatext((graphicwidth Sar $01), (Int ((Float ($3C + local4)) * menuscale)), (Str max((Float f2s((nvtimer / 60.0), $01)), 0.0)), $01, $00, 1.0)
            aatext((graphicwidth Sar $01), (Int ((Float ($64 + local4)) * menuscale)), "SECONDS", $01, $00, 1.0)
            local5 = createpivot($00)
            local6 = createpivot($00)
            positionentity(local5, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00)
            color($FF, $FF, $FF)
            For local3 = Each npcs
                If (((local3\Field43 <> "") And (local3\Field66 = $00)) <> 0) Then
                    positionentity(local6, local3\Field40, local3\Field41, local3\Field42, $00)
                    local7 = entitydistance(local6, collider)
                    If (23.5 > local7) Then
                        pointentity(local5, local6, 0.0)
                        local8 = wrapangle((entityyaw(camera, $00) - entityyaw(local5, $00)))
                        local9 = 0.0
                        If (((90.0 < local8) And (180.0 >= local8)) <> 0) Then
                            local9 = ((sin(90.0) / 90.0) * local8)
                        ElseIf (((180.0 < local8) And (270.0 > local8)) <> 0) Then
                            local9 = ((sin(270.0) / local8) * 270.0)
                        Else
                            local9 = sin(local8)
                        EndIf
                        local10 = wrapangle((entitypitch(camera, $00) - entitypitch(local5, $00)))
                        local11 = 0.0
                        If (((90.0 < local10) And (180.0 >= local10)) <> 0) Then
                            local11 = ((sin(90.0) / 90.0) * local10)
                        ElseIf (((180.0 < local10) And (270.0 > local10)) <> 0) Then
                            local11 = ((sin(270.0) / local10) * 270.0)
                        Else
                            local11 = sin(local10)
                        EndIf
                        If (isnvgblinking = $00) Then
                            aatext((Int ((local9 * (Float (graphicwidth Sar $01))) + (Float (graphicwidth Sar $01)))), (Int ((Float (graphicheight Sar $01)) - (local11 * (Float (graphicheight Sar $01))))), local3\Field43, $01, $01, 1.0)
                            aatext((Int ((local9 * (Float (graphicwidth Sar $01))) + (Float (graphicwidth Sar $01)))), (Int (((Float (graphicheight Sar $01)) - (local11 * (Float (graphicheight Sar $01)))) + (30.0 * menuscale))), (f2s(local7, $01) + " m"), $01, $01, 1.0)
                        EndIf
                    EndIf
                EndIf
            Next
            freeentity(local5)
            freeentity(local6)
            color($00, $00, $37)
            For local12 = $00 To $0A Step $01
                rect($2D, (Int (((Float graphicheight) * 0.5) - (Float (local12 * $14)))), $36, $0A, $01)
            Next
            color($00, $00, $FF)
            For local13 = $00 To (Int floor(((Float (local1 + $32)) * 0.01))) Step $01
                rect($2D, (Int (((Float graphicheight) * 0.5) - (Float (local13 * $14)))), $36, $0A, $01)
            Next
            drawimage(nvgimages, $28, (Int (((Float graphicheight) * 0.5) + 30.0)), $01)
            color($FF, $FF, $FF)
        ElseIf (((wearingnightvision = $01) And (local0 <> $00)) <> 0) Then
            color($00, $37, $00)
            For local12 = $00 To $0A Step $01
                rect($2D, (Int (((Float graphicheight) * 0.5) - (Float (local12 * $14)))), $36, $0A, $01)
            Next
            color($00, $FF, $00)
            For local13 = $00 To (Int floor(((Float (local1 + $32)) * 0.01))) Step $01
                rect($2D, (Int (((Float graphicheight) * 0.5) - (Float (local13 * $14)))), $36, $0A, $01)
            Next
            drawimage(nvgimages, $28, (Int (((Float graphicheight) * 0.5) + 30.0)), $00)
        EndIf
    EndIf
    cameraprojmode(ark_blur_cam, $02)
    cameraprojmode(camera, $00)
    renderworld(arg0)
    cameraprojmode(ark_blur_cam, $00)
    Return $00
End Function
