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
    Local local9#
    Local local10%
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    Local local15%[5]
    Local local16%[5]
    Local local17%
    Local local18%
    Local local19#
    Local local21%
    Local local22#
    Local local23#
    Local local25%[4]
    Local local26#
    Local local27#
    Local local28%
    Local local29.items
    catcherrors((((((("PlaceForest(" + (Str arg1)) + ", ") + (Str arg2)) + ", ") + (Str arg3)) + ")"))
    local2 = 12.0
    destroyforest(arg0, $00)
    arg0\Field4 = createpivot($00)
    positionentity(arg0\Field4, arg1, arg2, arg3, $01)
    local17 = loadtexture_strict("GFX\Map\Textures\forestfloor.jpg", $01, $00, $01)
    local18 = loadtexture_strict("GFX\Map\Textures\forestpath.jpg", $01, $00, $01)
    local15[$00] = loadimage_strict("GFX\Map\Forest\forest1h.png")
    local16[$00] = loadtexture_strict("GFX\Map\Forest\forest1h_mask.png", ((opt\Field3 Shl $08) + $03), $00, $00)
    local15[$01] = loadimage_strict("GFX\Map\Forest\forest2h.png")
    local16[$01] = loadtexture_strict("GFX\Map\Forest\forest2h_mask.png", ((opt\Field3 Shl $08) + $03), $00, $00)
    local15[$02] = loadimage_strict("GFX\Map\Forest\forest2Ch.png")
    local16[$02] = loadtexture_strict("GFX\Map\Forest\forest2Ch_mask.png", ((opt\Field3 Shl $08) + $03), $00, $00)
    local15[$03] = loadimage_strict("GFX\Map\Forest\forest3h.png")
    local16[$03] = loadtexture_strict("GFX\Map\Forest\forest3h_mask.png", ((opt\Field3 Shl $08) + $03), $00, $00)
    local15[$04] = loadimage_strict("GFX\Map\Forest\forest4h.png")
    local16[$04] = loadtexture_strict("GFX\Map\Forest\forest4h_mask.png", ((opt\Field3 Shl $08) + $03), $00, $00)
    For local10 = $00 To $04 Step $01
        arg0\Field0[local10] = loadterrain(local15[local10], 0.03, local17, local18, local16[local10])
        hideentity(arg0\Field0[local10])
        deletesingletextureentryfromcache(local16[local10], $00)
        local16[local10] = $00
    Next
    deletesingletextureentryfromcache(local17, $00)
    local17 = $00
    deletesingletextureentryfromcache(local18, $00)
    local18 = $00
    arg0\Field1[$00] = loadmesh_strict("GFX\Map\Props\tree1.b3d", $00)
    arg0\Field1[$01] = loadmesh_strict("GFX\Map\Props\rock.b3d", $00)
    arg0\Field1[$02] = loadmesh_strict("GFX\Map\Props\tree2.b3d", $00)
    arg0\Field1[$03] = loadrmesh("GFX\Map\cont2_860_1_wall.rmesh", Null, $01)
    For local10 = $00 To $03 Step $01
        hideentity(arg0\Field1[local10])
    Next
    local8 = meshwidth(arg0\Field0[$00])
    local6 = (local2 / local8)
    For local0 = $00 To $09 Step $01
        For local1 = $01 To $08 Step $01
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
                local19 = 0.0
                Select local3
                    Case $01
                        local4 = copyentity(arg0\Field0[$00], $00)
                        If (arg0\Field2[(((local1 + $01) * $0A) + local0)] > $00) Then
                            local19 = 180.0
                        ElseIf (arg0\Field2[((local1 * $0A) + (local0 - $01))] > $00) Then
                            local19 = 270.0
                        ElseIf (arg0\Field2[((local1 * $0A) + (local0 + $01))] > $00) Then
                            local19 = 90.0
                        EndIf
                        local3 = $01
                    Case $02
                        If (((arg0\Field2[(((local1 - $01) * $0A) + local0)] > $00) And (arg0\Field2[(((local1 + $01) * $0A) + local0)] > $00)) <> 0) Then
                            local4 = copyentity(arg0\Field0[$01], $00)
                            local3 = $02
                        ElseIf (((arg0\Field2[(((local1 * $0A) + local0) + $01)] > $00) And (arg0\Field2[(((local1 * $0A) + local0) - $01)] > $00)) <> 0) Then
                            local4 = copyentity(arg0\Field0[$01], $00)
                            local19 = 90.0
                            local3 = $02
                        Else
                            local4 = copyentity(arg0\Field0[$02], $00)
                            If (((arg0\Field2[(((local1 * $0A) + local0) - $01)] > $00) And (arg0\Field2[(((local1 + $01) * $0A) + local0)] > $00)) <> 0) Then
                                local19 = 180.0
                            ElseIf (((arg0\Field2[(((local1 * $0A) + local0) + $01)] > $00) And (arg0\Field2[(((local1 - $01) * $0A) + local0)] > $00)) <> 0) Then
                                local19 = 0.0
                            ElseIf (((arg0\Field2[(((local1 * $0A) + local0) - $01)] > $00) And (arg0\Field2[(((local1 - $01) * $0A) + local0)] > $00)) <> 0) Then
                                local19 = 270.0
                            Else
                                local19 = 90.0
                            EndIf
                            local3 = $03
                        EndIf
                    Case $03
                        local4 = copyentity(arg0\Field0[$03], $00)
                        If (arg0\Field2[(((local1 - $01) * $0A) + local0)] = $00) Then
                            local19 = 180.0
                        ElseIf (arg0\Field2[(((local1 * $0A) + local0) - $01)] = $00) Then
                            local19 = 90.0
                        ElseIf (arg0\Field2[(((local1 * $0A) + local0) + $01)] = $00) Then
                            local19 = 270.0
                        EndIf
                        local3 = $04
                    Case $04
                        local4 = copyentity(arg0\Field0[$04], $00)
                        local19 = ((Float (arg0\Field2[((local1 * $0A) + local0)] Mod $04)) * 90.0)
                        local3 = $05
                End Select
                If (local3 > $00) Then
                    setbuffer(imagebuffer(local15[(local3 - $01)], $00))
                    local11 = imagewidth(local15[(local3 - $01)])
                    local9 = (local8 / (Float local11))
                    For local12 = $03 To (local11 - $02) Step $01
                        For local13 = $03 To (local11 - $02) Step $01
                            getcolor(local12, (local11 - local13))
                            local21 = colorred()
                            local22 = (((Float local12) * local9) - (local8 / 2.0))
                            local23 = (((Float local13) * local9) - (local8 / 2.0))
                            If (local21 > rand($64, $104)) Then
                                local5 = $00
                                Select rand($00, $07)
                                    Case $00,$01,$02,$03,$04,$05,$06
                                        local5 = copyentity(arg0\Field1[$00], $00)
                                        local7 = rnd(0.25, 0.4)
                                        For local10 = $00 To $03 Step $01
                                            local14 = copyentity(arg0\Field1[$02], $00)
                                            rotateentity(local14, 0.0, ((90.0 * (Float local10)) + rnd(-20.0, 20.0)), 0.0, $00)
                                            entityparent(local14, local5, $01)
                                            entityfx(local14, $01)
                                        Next
                                        scaleentity(local5, (local7 * 1.1), local7, (local7 * 1.1), $01)
                                        positionentity(local5, local22, (((Float local21) * 0.03) - rnd(3.0, 3.2)), local23, $01)
                                        rotateentity(local5, rnd(-5.0, 5.0), rnd(360.0, 0.0), 0.0, $01)
                                    Case $07
                                        local5 = copyentity(arg0\Field1[$01], $00)
                                        local7 = rnd(0.01, 0.012)
                                        positionentity(local5, local22, (((Float local21) * 0.03) - 1.3), local23, $01)
                                        rotateentity(local5, 0.0, rnd(360.0, 0.0), 0.0, $01)
                                End Select
                                If (local5 <> $00) Then
                                    entityfx(local5, $01)
                                    entityparent(local5, local4, $01)
                                EndIf
                            EndIf
                        Next
                    Next
                    setbuffer(backbuffer())
                    scaleentity(local4, local6, local6, local6, $00)
                    local28 = (Int floor((Float (local1 / $03))))
                    local29 = Null
                    If ((((local1 Mod $03) = $02) And (local25[local28] = $00)) <> 0) Then
                        local25[local28] = $01
                        If (local3 = $01) Then
                            local26 = 0.4
                            local27 = 0.0
                        ElseIf (local3 = $03) Then
                            local26 = 1.7
                            local27 = -1.0
                        Else
                            local26 = 0.0
                            local27 = 0.0
                        EndIf
                        local29 = createitem(("Log #" + (Str (local28 + $01))), $00, local26, 0.2, local27, $00, $00, $00, 1.0, $00)
                        entitytype(local29\Field2, $03, $00)
                        entityparent(local29\Field2, local4, $01)
                    EndIf
                    turnentity(local4, 0.0, local19, 0.0, $00)
                    positionentity(local4, (((Float local0) * local2) + arg1), arg2, (((Float local1) * local2) + arg3), $01)
                    entitytype(local4, $01, $00)
                    entityfx(local4, $01)
                    entityparent(local4, arg0\Field4, $01)
                    entitypickmode(local4, $02, $01)
                    If (local29 <> Null) Then
                        entityparent(local29\Field2, $00, $01)
                    EndIf
                    arg0\Field3[((local1 * $0A) + local0)] = local4
                    hideentity(arg0\Field3[((local1 * $0A) + local0)])
                EndIf
            EndIf
        Next
    Next
    freeimage(local15[local10])
    local15[local10] = $00
    For local10 = $00 To $01 Step $01
        local1 = (local10 * $09)
        For local0 = $03 To $07 Step $01
            If (arg0\Field2[((local1 * $0A) + local0)] = $03) Then
                arg0\Field6[local10] = copyentity(arg0\Field1[$03], $00)
                scaleentity(arg0\Field6[local10], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                arg0\Field5[local10] = createdoor(Null, 0.0, 0.125, 0.0, 180.0, $00, $05, $FFFFFFFC, $00, arg0\Field6[local10])
                arg0\Field5[local10]\Field4 = $02
                arg0\Field5[local10]\Field38 = $01
                entitytype(arg0\Field6[local10], $01, $00)
                entitypickmode(arg0\Field6[local10], $02, $01)
                positionentity(arg0\Field6[local10], (((Float local0) * local2) + arg1), arg2, (((((Float local1) * local2) + arg3) + (local2 / 2.0)) - (local2 * (Float local10))), $01)
                rotateentity(arg0\Field6[local10], 0.0, (180.0 * (Float local10)), 0.0, $00)
                entityparent(arg0\Field6[local10], arg0\Field4, $01)
                Exit
            EndIf
        Next
    Next
    catcherrors((((((("Uncaught: PlaceForest(" + (Str arg1)) + ", ") + (Str arg2)) + ", ") + (Str arg3)) + ")"))
    Return $00
End Function
