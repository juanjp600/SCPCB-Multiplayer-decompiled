Function placemapcreatorforest%(arg0.forest, arg1#, arg2#, arg3#, arg4.rooms)
    Local local0%
    Local local1%
    Local local2#
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7#
    Local local8#
    Local local9#
    Local local10#
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    Local local16%[5]
    Local local17%[5]
    Local local18%
    Local local19%
    Local local20#
    Local local21%
    Local local22#
    Local local23#
    Local local25%[4]
    Local local26#
    Local local27#
    Local local28%
    Local local29.items
    catcherrors((((((("PlaceMapCreatorForest(" + (Str arg1)) + ", ") + (Str arg2)) + ", ") + (Str arg3)) + ")"))
    local2 = 12.0
    destroyforest(arg0, $00)
    arg0\Field4 = createpivot($00)
    positionentity(arg0\Field4, arg1, arg2, arg3, $01)
    local18 = loadtexture_strict("GFX\Map\Textures\forestfloor.jpg", $01, $00, $01)
    local19 = loadtexture_strict("GFX\Map\Textures\forestpath.jpg", $01, $00, $01)
    local16[$00] = loadimage_strict("GFX\Map\Forest\forest1h.png")
    local17[$00] = loadtexture_strict("GFX\Map\Forest\forest1h_mask.png", ((opt\Field3 Shl $08) + $03), $00, $00)
    local16[$01] = loadimage_strict("GFX\Map\Forest\forest2h.png")
    local17[$01] = loadtexture_strict("GFX\Map\Forest\forest2h_mask.png", ((opt\Field3 Shl $08) + $03), $00, $00)
    local16[$02] = loadimage_strict("GFX\Map\Forest\forest2Ch.png")
    local17[$02] = loadtexture_strict("GFX\Map\Forest\forest2Ch_mask.png", ((opt\Field3 Shl $08) + $03), $00, $00)
    local16[$03] = loadimage_strict("GFX\Map\Forest\forest3h.png")
    local17[$03] = loadtexture_strict("GFX\Map\Forest\forest3h_mask.png", ((opt\Field3 Shl $08) + $03), $00, $00)
    local16[$04] = loadimage_strict("GFX\Map\Forest\forest4h.png")
    local17[$04] = loadtexture_strict("GFX\Map\Forest\forest4h_mask.png", ((opt\Field3 Shl $08) + $03), $00, $00)
    For local11 = $00 To $04 Step $01
        arg0\Field0[local11] = loadterrain(local16[local11], 0.03, local18, local19, local17[local11])
        hideentity(arg0\Field0[local11])
        deletesingletextureentryfromcache(local17[local11], $00)
        local17[local11] = $00
    Next
    deletesingletextureentryfromcache(local18, $00)
    local18 = $00
    deletesingletextureentryfromcache(local19, $00)
    local19 = $00
    arg0\Field1[$00] = loadmesh_strict("GFX\Map\Props\tree1.b3d", $00)
    arg0\Field1[$01] = loadmesh_strict("GFX\Map\Props\rock.b3d", $00)
    arg0\Field1[$02] = loadmesh_strict("GFX\Map\Props\tree2.b3d", $00)
    arg0\Field1[$03] = loadrmesh("GFX\Map\cont2_860_1_wall.rmesh", Null, $01)
    For local11 = $00 To $03 Step $01
        hideentity(arg0\Field1[local11])
    Next
    local9 = meshwidth(arg0\Field0[$00])
    local7 = (local2 / local9)
    For local0 = $00 To $09 Step $01
        For local1 = $00 To $09 Step $01
            If (arg0\Field2[((local1 * $0A) + local0)] > $00) Then
                local3 = $00
                local20 = 0.0
                local3 = (Int ceil(((Float arg0\Field2[((local1 * $0A) + local0)]) / 4.0)))
                If (local3 = $06) Then
                    local3 = $02
                EndIf
                local20 = ((Float (arg0\Field2[((local1 * $0A) + local0)] Mod $04)) * 90.0)
                local5 = copyentity(arg0\Field0[(local3 - $01)], $00)
                If (local3 > $00) Then
                    setbuffer(imagebuffer(local16[(local3 - $01)], $00))
                    local12 = imagewidth(local16[(local3 - $01)])
                    local10 = (local9 / (Float local12))
                    For local13 = $03 To (local12 - $02) Step $01
                        For local14 = $03 To (local12 - $02) Step $01
                            getcolor(local13, (local12 - local14))
                            local21 = colorred()
                            local22 = (((Float local13) * local10) - (local9 / 2.0))
                            local23 = (((Float local14) * local10) - (local9 / 2.0))
                            If (local21 > rand($64, $104)) Then
                                local4 = $00
                                Select rand($00, $07)
                                    Case $00,$01,$02,$03,$04,$05,$06
                                        local4 = copyentity(arg0\Field1[$00], $00)
                                        local8 = rnd(0.25, 0.4)
                                        For local11 = $00 To $03 Step $01
                                            local15 = copyentity(arg0\Field1[$02], $00)
                                            rotateentity(local15, 0.0, ((90.0 * (Float local11)) + rnd(-20.0, 20.0)), 0.0, $00)
                                            entityparent(local15, local4, $01)
                                            entityfx(local15, $01)
                                        Next
                                        scaleentity(local4, (local8 * 1.1), local8, (local8 * 1.1), $01)
                                        positionentity(local4, local22, (((Float local21) * 0.03) - rnd(3.0, 3.2)), local23, $01)
                                        rotateentity(local4, rnd(-5.0, 5.0), rnd(360.0, 0.0), 0.0, $01)
                                    Case $07
                                        local4 = copyentity(arg0\Field1[$01], $00)
                                        local8 = rnd(0.01, 0.012)
                                        positionentity(local4, local22, (((Float local21) * 0.03) - 1.3), local23, $01)
                                        rotateentity(local4, 0.0, rnd(360.0, 0.0), 0.0, $01)
                                End Select
                                If (local4 <> $00) Then
                                    entityfx(local4, $01)
                                    entityparent(local4, local5, $01)
                                EndIf
                            EndIf
                        Next
                    Next
                    setbuffer(backbuffer())
                    scaleentity(local5, local7, local7, local7, $00)
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
                        entityparent(local29\Field2, local5, $01)
                    EndIf
                    turnentity(local5, 0.0, local20, 0.0, $00)
                    positionentity(local5, (((Float local0) * local2) + arg1), arg2, (((Float local1) * local2) + arg3), $01)
                    entitytype(local5, $01, $00)
                    entityfx(local5, $01)
                    entityparent(local5, arg0\Field4, $01)
                    entitypickmode(local5, $02, $01)
                    If (local29 <> Null) Then
                        entityparent(local29\Field2, $00, $01)
                    EndIf
                    arg0\Field3[((local1 * $0A) + local0)] = local5
                    hideentity(arg0\Field3[((local1 * $0A) + local0)])
                EndIf
                If (6.0 = ceil(((Float arg0\Field2[((local1 * $0A) + local0)]) / 4.0))) Then
                    For local11 = $00 To $01 Step $01
                        If (arg0\Field5[local11] = Null) Then
                            arg0\Field6[local11] = copyentity(arg0\Field1[$03], $00)
                            scaleentity(arg0\Field6[local11], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                            arg0\Field5[local11] = createdoor(Null, 0.0, 0.125, 0.0, 180.0, $00, $05, $FFFFFFFC, $00, arg0\Field6[local11])
                            arg0\Field5[local11]\Field4 = $02
                            arg0\Field5[local11]\Field38 = $01
                            entitytype(arg0\Field6[local11], $01, $00)
                            entitypickmode(arg0\Field6[local11], $02, $01)
                            positionentity(arg0\Field6[local11], (((Float local0) * local2) + arg1), arg2, (((Float local1) * local2) + arg3), $01)
                            rotateentity(arg0\Field6[local11], 0.0, (local20 + 180.0), 0.0, $00)
                            moveentity(arg0\Field6[local11], 0.0, 0.0, -6.0)
                            entityparent(arg0\Field6[local11], arg0\Field4, $01)
                            Exit
                        EndIf
                    Next
                EndIf
            EndIf
        Next
    Next
    freeimage(local16[local11])
    local16[local11] = $00
    catcherrors((((((("Uncaught: PlaceMapCreatorForest(" + (Str arg1)) + ", ") + (Str arg2)) + ", ") + (Str arg3)) + ")"))
    Return $00
End Function
