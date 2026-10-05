Function render3d%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6#
    Local local7#
    Local local8#
    Local local9$
    Local local10%
    Local local11%
    Local local12$
    Local local13%
    Local local14%
    Local local15.npcs
    Local local16.players
    Local local17%
    local9 = playerroom\Field8\Field11
    If (((local9 = "gatea") Or ((local9 = "exit1") And (4.0 < entityy(collider, $00)))) <> 0) Then
        update3dsky($00)
        entityorder(landscapecamera, $01)
        entityorder(camera, $00)
        cameraprojmode(landscapecamera, $01)
        showentity(landscapeobj)
        cameraclsmode(camera, $00, $01)
    Else
        cameraclsmode(camera, $01, $01)
        hideentity(landscapeobj)
    EndIf
    cameraprojmode(ark_blur_cam, $00)
    cameraprojmode(camera, $01)
    If (wearingnightvision > $00) Then
        If (wearingnightvision < $03) Then
            ambientlight(min(1200.0, 255.0), min(360.0, 255.0), min(360.0, 255.0))
        EndIf
    EndIf
    isnvgblinking = $00
    hideentity(nvblink)
    If (getscripts() <> 0) Then
        public_inqueue($07, $01)
    EndIf
    local10 = $02
    local11 = $00
    If (((wearingnightvision = $01) Or (wearingnightvision = $02)) <> 0) Then
        local12 = "nvgoggles"
        If (wearingnightvision = $02) Then
            local12 = "supernv"
        EndIf
        For local13 = $00 To $09 Step $01
            If (inventory(local13) <> Null) Then
                If (inventory(local13)\Field1\Field2 = local12) Then
                    inventory(local13)\Field13 = (inventory(local13)\Field13 - ((0.02 * (Float wearingnightvision)) * fpsfactor))
                    local11 = (Int inventory(local13)\Field13)
                    local10 = $01
                    Exit
                EndIf
            EndIf
        Next
    EndIf
    renderworld(1.0)
    If (eqquipedgun <> Null) Then
        cameraclsmode(camera, $00, $00)
        renderentity(eqquipedgun\Field10, camera, 1.0)
    EndIf
    local14 = ((Int ((Float (local11 + $32)) * 0.01)) Shl $04)
    currtrisamount = trisrendered()
    If (((local10 = $00) And (wearingnightvision <> $03)) <> 0) Then
        isnvgblinking = $01
        showentity(nvblink)
    EndIf
    If (((-16.0 > blinktimer) Or (-6.0 < blinktimer)) <> 0) Then
        If (((wearingnightvision = $02) And (local10 <> $00)) <> 0) Then
            nvtimer = (nvtimer - fpsfactor)
            If (networkserver\Field12 = $00) Then
                If (0.0 >= nvtimer) Then
                    For local15 = Each npcs
                        If (((local15\Field43 <> "") And (local15\Field68 = $00)) <> 0) Then
                            local15\Field40 = entityx(local15\Field4, $01)
                            local15\Field41 = entityy(local15\Field4, $01)
                            local15\Field42 = entityz(local15\Field4, $01)
                        EndIf
                    Next
                    isnvgblinking = $01
                    showentity(nvblink)
                    If (-10.0 >= nvtimer) Then
                        nvtimer = 600.0
                    EndIf
                EndIf
            ElseIf (0.0 >= nvtimer) Then
                For local16 = Each players
                    If (local16\Field110 <> "") Then
                        local16\Field107 = entityx(local16\Field13, $01)
                        local16\Field108 = entityy(local16\Field13, $01)
                        local16\Field109 = entityz(local16\Field13, $01)
                    EndIf
                Next
                isnvgblinking = $01
                showentity(nvblink)
                If (-10.0 >= nvtimer) Then
                    nvtimer = 600.0
                EndIf
            EndIf
            setcolorraw($FFFFFF)
            setfontex(fonts[$02]\Field0)
            local17 = $00
            If (local10 = $01) Then
                local17 = $28
            EndIf
            text(viewport_center_x, (Int ((Float ($14 + local17)) * menuscale)), "REFRESHING DATA IN", $01, $00)
            text(viewport_center_x, (Int ((Float ($3C + local17)) * menuscale)), (Str max((Float f2s((nvtimer * (1.0 / 59.99999)), $01)), 0.0)), $01, $00)
            text(viewport_center_x, (Int ((Float ($64 + local17)) * menuscale)), "SECONDS", $01, $00)
            If (networkserver\Field12 = $00) Then
                For local15 = Each npcs
                    If (local15\Field43 <> "") Then
                        cameraproject(camera, local15\Field40, local15\Field41, local15\Field42)
                        local8 = projectedz()
                        If (((0.0 < local8) And (10.5 > local8)) <> 0) Then
                            If (isnvgblinking = $00) Then
                                local6 = projectedx()
                                local7 = projectedy()
                                text((Int local6), (Int local7), local15\Field43, $01, $01)
                                text((Int local6), (Int (local7 + (Float imenuscale[$1E]))), (f2s(local8, $01) + " m"), $01, $01)
                            EndIf
                        EndIf
                    EndIf
                Next
            Else
                For local16 = Each players
                    If (local16\Field110 <> "") Then
                        cameraproject(camera, local16\Field107, local16\Field108, local16\Field109)
                        local8 = projectedz()
                        If (((0.0 < local8) And (10.5 > local8)) <> 0) Then
                            If (isnvgblinking = $00) Then
                                local6 = projectedx()
                                local7 = projectedy()
                                text((Int local6), (Int local7), local16\Field110, $01, $01)
                                text((Int local6), (Int (local7 + (Float imenuscale[$1E]))), ((Str (Int local8)) + " m"), $01, $01)
                            EndIf
                        EndIf
                    EndIf
                Next
            EndIf
            setcolorraw($FF000037)
            rect($2D, (viewport_center_y - $C8), $36, $D2, $01)
            setcolorraw($FF0000FF)
            rect($2D, (viewport_center_y - local14), $36, (local14 + $0A), $01)
            drawimage(nvgimages, $28, (viewport_center_y + $1E), $01)
        ElseIf (((wearingnightvision = $01) And (local10 <> $00)) <> 0) Then
            setcolorraw($FF003700)
            rect($2D, (viewport_center_y - $C8), $36, $D2, $01)
            setcolorraw($FF00FF00)
            rect($2D, (viewport_center_y - local14), $36, (local14 + $0A), $01)
            drawimage(nvgimages, $28, (viewport_center_y + $1E), $00)
        EndIf
    EndIf
    cameraprojmode(landscapecamera, $00)
    cameraprojmode(ark_blur_cam, $02)
    cameraprojmode(camera, $00)
    renderworld(1.0)
    cameraprojmode(ark_blur_cam, $00)
    Return $00
End Function
