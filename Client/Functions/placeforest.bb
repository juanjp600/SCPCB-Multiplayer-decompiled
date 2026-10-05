Function placeforest%(arg0.forest, arg1#, arg2#, arg3#, arg4.rooms)
    Local local0%
    Local local1%
    Local local2#
    Local local3%
    Local local4%
    Local local5%
    Local local6#
    Local local7#
    Local local8#
    Local local9%
    Local local10%[5]
    Local local11%[5]
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    Local local17%
    Local local18#
    Local local19#
    Local local20%
    Local local21%
    Local local22#
    Local local23#
    Local local24#
    Local local25#
    Local local26#
    Local local27#
    Local local29%
    Local local30%
    Local local31%[4]
    Local local32.items
    Local local33%
    local2 = 12.0
    If (arg0\Field4 <> $00) Then
        freeentity(arg0\Field4)
        arg0\Field4 = $00
    EndIf
    For local9 = $01 To $05 Step $01
        If (arg0\Field0[local9] <> $00) Then
            freeentity(arg0\Field0[local9])
            arg0\Field0[local9] = $00
        EndIf
    Next
    For local9 = $00 To $04 Step $01
        If (arg0\Field1[local9] <> $00) Then
            freeentity(arg0\Field1[local9])
            arg0\Field1[local9] = $00
        EndIf
    Next
    arg0\Field4 = createpivot($00)
    positionentity(arg0\Field4, arg1, arg2, arg3, $01)
    local12 = loadtexture_strict("GFX\map\forest\forestfloor.jpg", $01)
    local13 = loadtexture_strict("GFX\map\forest\forestpath.jpg", $01)
    local14 = loadtexture_strict("GFX\map\forest\detail\grass.png", $06)
    local10[$01] = loadimage_strict("GFX\map\forest\forest1h.png")
    local11[$01] = loadtexture_strict("GFX\map\forest\forest1h_mask.png", $03)
    local10[$02] = loadimage_strict("GFX\map\forest\forest2h.png")
    local11[$02] = loadtexture_strict("GFX\map\forest\forest2h_mask.png", $03)
    local10[$03] = loadimage_strict("GFX\map\forest\forest2Ch.png")
    local11[$03] = loadtexture_strict("GFX\map\forest\forest2Ch_mask.png", $03)
    local10[$04] = loadimage_strict("GFX\map\forest\forest3h.png")
    local11[$04] = loadtexture_strict("GFX\map\forest\forest3h_mask.png", $03)
    local10[$05] = loadimage_strict("GFX\map\forest\forest4h.png")
    local11[$05] = loadtexture_strict("GFX\map\forest\forest4h_mask.png", $03)
    For local9 = $01 To $05 Step $01
        arg0\Field0[local9] = load_terrain(local10[local9], 0.025, local12, local13, local11[local9])
    Next
    freetexture(local12)
    freetexture(local13)
    arg0\Field1[$00] = loadmesh_strict("GFX\map\forest\detail\tree.b3d", $00)
    arg0\Field1[$01] = loadmesh_strict("GFX\map\forest\detail\rock.b3d", $00)
    arg0\Field1[$02] = loadmesh_strict("GFX\map\forest\detail\rock2.b3d", $00)
    arg0\Field1[$03] = loadmesh_strict("GFX\map\forest\detail\rock3.b3d", $00)
    arg0\Field1[$04] = loadmesh_strict("GFX\map\forest\wall.b3d", $00)
    arg0\Field1[$05] = loadmesh_strict("GFX\map\forest\detail\stick.b3d", $00)
    arg0\Field1[$06] = loadmesh_strict("GFX\map\forest\\detail\TreeStump.b3d", $00)
    For local9 = $01 To $05 Step $01
        hideentity(arg0\Field0[local9])
    Next
    For local9 = $00 To $06 Step $01
        hideentity(arg0\Field1[local9])
    Next
    local8 = meshwidth(arg0\Field0[$01])
    local6 = (local2 / local8)
    For local0 = $00 To $09 Step $01
        For local1 = $00 To $09 Step $01
            If (arg0\Field2[((local1 * $0A) + local0)] = $01) Then
                local3 = $00
                If ((local0 + $01) < $0A) Then
                    local3 = (arg0\Field2[(((local1 * $0A) + local0) + $01)] > $00)
                EndIf
                If ((local0 - $01) >= $00) Then
                    local3 = (local3 + (arg0\Field2[(((local1 * $0A) + local0) - $01)] > $00))
                EndIf
                If ((local1 + $01) < $0A) Then
                    local3 = (local3 + (arg0\Field2[(((local1 + $01) * $0A) + local0)] > $00))
                EndIf
                If ((local1 - $01) >= $00) Then
                    local3 = (local3 + (arg0\Field2[(((local1 - $01) * $0A) + local0)] > $00))
                EndIf
                local15 = $00
                Select local3
                    Case $01
                        local4 = copyentity(arg0\Field0[$01], $00)
                        If (arg0\Field2[(((local1 + $01) * $0A) + local0)] > $00) Then
                            local15 = $B4
                        ElseIf (arg0\Field2[(((local1 * $0A) + local0) - $01)] > $00) Then
                            local15 = $10E
                        ElseIf (arg0\Field2[(((local1 * $0A) + local0) + $01)] > $00) Then
                            local15 = $5A
                        EndIf
                        local3 = $01
                    Case $02
                        If (((arg0\Field2[(((local1 - $01) * $0A) + local0)] > $00) And (arg0\Field2[(((local1 + $01) * $0A) + local0)] > $00)) <> 0) Then
                            local4 = copyentity(arg0\Field0[$02], $00)
                            local3 = $02
                        ElseIf (((arg0\Field2[(((local1 * $0A) + local0) + $01)] > $00) And (arg0\Field2[(((local1 * $0A) + local0) - $01)] > $00)) <> 0) Then
                            local4 = copyentity(arg0\Field0[$02], $00)
                            local15 = $5A
                            local3 = $02
                        Else
                            local4 = copyentity(arg0\Field0[$03], $00)
                            If (((arg0\Field2[(((local1 * $0A) + local0) - $01)] > $00) And (arg0\Field2[(((local1 + $01) * $0A) + local0)] > $00)) <> 0) Then
                                local15 = $B4
                            ElseIf (((arg0\Field2[(((local1 * $0A) + local0) + $01)] > $00) And (arg0\Field2[(((local1 - $01) * $0A) + local0)] > $00)) = 0) Then
                                If (((arg0\Field2[(((local1 * $0A) + local0) - $01)] > $00) And (arg0\Field2[(((local1 - $01) * $0A) + local0)] > $00)) <> 0) Then
                                    local15 = $10E
                                Else
                                    local15 = $5A
                                EndIf
                            EndIf
                            local3 = $03
                        EndIf
                    Case $03
                        local4 = copyentity(arg0\Field0[$04], $00)
                        If (arg0\Field2[(((local1 - $01) * $0A) + local0)] = $00) Then
                            local15 = $B4
                        ElseIf (arg0\Field2[(((local1 * $0A) + local0) - $01)] = $00) Then
                            local15 = $5A
                        ElseIf (arg0\Field2[(((local1 * $0A) + local0) + $01)] = $00) Then
                            local15 = $10E
                        EndIf
                        local3 = $04
                    Case $04
                        local4 = copyentity(arg0\Field0[$05], $00)
                        local3 = $05
                End Select
                If (local3 > $00) Then
                    scaleentity(local4, local6, local6, local6, $00)
                    turnentity(local4, 0.0, (Float local15), 0.0, $00)
                    positionentity(local4, (((Float local0) * local2) + arg1), arg2, (((Float local1) * local2) + arg3), $01)
                    entitytype(local4, $01, $00)
                    entityfx(local4, $01)
                    entityparent(local4, arg0\Field4, $01)
                    entitypickmode(local4, $02, $01)
                    resetentity(local4)
                    setbuffer(imagebuffer(local10[local3], $00))
                    local17 = imagewidth(local10[local3])
                    local18 = (local8 / (Float local17))
                    local19 = (local8 * 0.5)
                    For local20 = $03 To (local17 - $02) Step $01
                        For local21 = $03 To (local17 - $02) Step $01
                            getcolor(local20, (local17 - local21))
                            local22 = (((Float local20) * local18) - local19)
                            local23 = (((Float local21) * local18) - local19)
                            local24 = ((Float colorred()) * 0.03)
                            If (rand($00, $64) = $0C) Then
                                local5 = copyentity(arg0\Field1[$05], $00)
                                local7 = rnd(0.05, 0.2)
                                scaleentity(local5, local7, local7, local7, $01)
                                entityparent(local5, local4, $01)
                                tformpoint(local22, (local24 + 20.0), local23, local4, $00)
                                local25 = tformedx()
                                local26 = tformedy()
                                local27 = tformedz()
                                linepick(local25, local26, local27, 0.0, -40.0, 0.0, 0.0)
                                If (pickedentity() <> $00) Then
                                    positionentity(local5, pickedx(), pickedy(), pickedz(), $01)
                                    aligntovector(local5, pickednx(), pickedny(), pickednz(), $02, 1.0)
                                    turnentity(local5, 0.0, rnd(360.0, 0.0), 0.0, $00)
                                Else
                                    positionentity(local5, local22, (local24 - 1.3), local23, $00)
                                    rotateentity(local5, 0.0, rnd(360.0, 0.0), 0.0, $00)
                                EndIf
                            EndIf
                            If (colorred() > rand($64, $104)) Then
                                local5 = $00
                                Select rand($00, $19)
                                    Case $00,$01,$02,$03,$04
                                        local5 = copyentity(arg0\Field1[$00], $00)
                                        entityparent(local5, local4, $01)
                                        local7 = rnd(0.25, 0.4)
                                        scaleentity(local5, 0.2, local7, 0.2, $00)
                                        positionentity(local5, local22, (local24 - 1.3), local23, $00)
                                        rotateentity(local5, 0.0, rnd(360.0, 0.0), 0.0, $00)
                                    Case $05,$06,$07,$08,$09,$0A,$0B,$0C,$0D,$0E,$0F
                                        tformpoint(local22, (local24 + 20.0), local23, local4, $00)
                                        local25 = tformedx()
                                        local26 = tformedy()
                                        local27 = tformedz()
                                        linepick(local25, local26, local27, 0.0, -40.0, 0.0, 0.0)
                                        If (((pickedentity() <> $00) And (0.85 < pickedny())) <> 0) Then
                                            local5 = creategrassmesh()
                                            entitytexture(local5, local14, $00, $00)
                                            entityparent(local5, local4, $01)
                                            local29 = (Int rnd(0.7, 1.2))
                                            local30 = (Int (rnd(1.5, 3.0) * pickedny()))
                                            scaleentity(local5, (Float local30), (Float local29), (Float local30), $00)
                                            positionentity(local5, pickedx(), pickedy(), pickedz(), $01)
                                            aligntovector(local5, pickednx(), pickedny(), pickednz(), $02, 1.0)
                                            turnentity(local5, 0.0, rnd(360.0, 0.0), 0.0, $00)
                                        Else
                                            local5 = $00
                                        EndIf
                                    Case $10
                                        local5 = copyentity(arg0\Field1[$01], $00)
                                        entityparent(local5, local4, $01)
                                        local7 = rnd(0.01, 0.012)
                                        scaleentity(local5, local7, local7, local7, $00)
                                        tformpoint(local22, (local24 + 20.0), local23, local4, $00)
                                        local25 = tformedx()
                                        local26 = tformedy()
                                        local27 = tformedz()
                                        linepick(local25, local26, local27, 0.0, -40.0, 0.0, 0.0)
                                        If (pickedentity() <> $00) Then
                                            positionentity(local5, pickedx(), pickedy(), pickedz(), $01)
                                            aligntovector(local5, pickednx(), pickedny(), pickednz(), $02, 1.0)
                                            turnentity(local5, 0.0, rnd(360.0, 0.0), 0.0, $00)
                                        Else
                                            positionentity(local5, local22, (local24 - 1.3), local23, $00)
                                            rotateentity(local5, 0.0, rnd(360.0, 0.0), 0.0, $00)
                                        EndIf
                                    Case $11
                                        local5 = copyentity(arg0\Field1[$02], $00)
                                        entityparent(local5, local4, $01)
                                        scaleentity(local5, 1.0, 1.0, 1.0, $00)
                                        tformpoint(local22, (local24 + 20.0), local23, local4, $00)
                                        local25 = tformedx()
                                        local26 = tformedy()
                                        local27 = tformedz()
                                        linepick(local25, local26, local27, 0.0, -40.0, 0.0, 0.0)
                                        If (pickedentity() <> $00) Then
                                            positionentity(local5, pickedx(), pickedy(), pickedz(), $01)
                                            aligntovector(local5, pickednx(), pickedny(), pickednz(), $02, 1.0)
                                            turnentity(local5, 0.0, rnd(360.0, 0.0), 0.0, $00)
                                        Else
                                            positionentity(local5, local22, (local24 - 1.3), local23, $00)
                                            rotateentity(local5, rnd(-10.0, 10.0), rnd(360.0, 0.0), rnd(-10.0, 10.0), $00)
                                        EndIf
                                    Case $12
                                        local5 = copyentity(arg0\Field1[$03], $00)
                                        entityparent(local5, local4, $01)
                                        scaleentity(local5, 0.3, 0.3, 0.3, $00)
                                        tformpoint(local22, (local24 + 20.0), local23, local4, $00)
                                        local25 = tformedx()
                                        local26 = tformedy()
                                        local27 = tformedz()
                                        linepick(local25, local26, local27, 0.0, -40.0, 0.0, 0.0)
                                        If (pickedentity() <> $00) Then
                                            positionentity(local5, pickedx(), pickedy(), pickedz(), $01)
                                            aligntovector(local5, pickednx(), pickedny(), pickednz(), $02, 1.0)
                                            turnentity(local5, 0.0, rnd(360.0, 0.0), 0.0, $00)
                                        Else
                                            positionentity(local5, local22, (local24 - 1.3), local23, $00)
                                            rotateentity(local5, rnd(-10.0, 10.0), rnd(360.0, 0.0), rnd(-10.0, 10.0), $00)
                                        EndIf
                                    Case $19
                                        local5 = copyentity(arg0\Field1[$06], $00)
                                        entityparent(local5, local4, $01)
                                        scaleentity(local5, 0.2, 0.2, 0.2, $00)
                                        positionentity(local5, local22, (local24 - rnd(-0.02, 0.02)), local23, $00)
                                        rotateentity(local5, 0.0, rnd(360.0, 0.0), 0.0, $00)
                                End Select
                            EndIf
                        Next
                    Next
                    setbuffer(backbuffer())
                    local32 = Null
                    If ((((local1 Mod $03) = $02) And (local31[(Int floor((Float (local1 / $03))))] = $00)) <> 0) Then
                        local31[(Int floor((Float (local1 / $03))))] = $01
                        local32 = createitem(("Log #" + (Str (Int (floor((Float (local1 / $03))) + 1.0)))), "paper", 0.0, 0.5, 0.0, $00, $00, $00, 1.0, $00, $01)
                        entitytype(local32\Field2, $03, $00)
                        entityparent(local32\Field2, local4, $01)
                    EndIf
                    If (local32 <> Null) Then
                        entityparent(local32\Field2, $00, $01)
                    EndIf
                    arg0\Field3[((local1 * $0A) + local0)] = local4
                EndIf
            EndIf
        Next
    Next
    For local9 = $00 To $01 Step $01
        local1 = ($09 * local9)
        For local0 = $00 To $09 Step $01
            If (arg0\Field2[((local1 * $0A) + local0)] = $03) Then
                arg0\Field6[local9] = copyentity(arg0\Field1[$04], $00)
                scaleentity(arg0\Field6[local9], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                arg0\Field5[local9] = copyentity(arg4\Field25[$03], $00)
                positionentity(arg0\Field5[local9], 0.28125, 0.125, 0.0, $01)
                rotateentity(arg0\Field5[local9], 0.0, 180.0, 0.0, $00)
                scaleentity(arg0\Field5[local9], 0.1875, (1.0 / 5.688889), 0.1875, $01)
                entityparent(arg0\Field5[local9], arg0\Field6[local9], $01)
                local33 = copyentity(arg4\Field25[$02], arg0\Field5[local9])
                positionentity(local33, 0.0, 0.125, 0.0, $01)
                scaleentity(local33, 0.1875, (1.0 / 5.688889), 0.1875, $01)
                entityparent(local33, arg0\Field6[local9], $01)
                entitytype(arg0\Field6[local9], $01, $00)
                entitypickmode(arg0\Field6[local9], $02, $01)
                positionentity(arg0\Field6[local9], (((Float local0) * local2) + arg1), arg2, (((((Float local1) * local2) + arg3) + (local2 / 2.0)) - (local2 * (Float local9))), $01)
                rotateentity(arg0\Field6[local9], 0.0, (Float ($B4 * local9)), 0.0, $00)
                entityparent(arg0\Field6[local9], arg0\Field4, $01)
            EndIf
        Next
    Next
    For local9 = $01 To $05 Step $01
        freeimage(local10[local9])
        freetexture(local11[local9])
    Next
    freetexture(local14)
    Return $00
End Function
