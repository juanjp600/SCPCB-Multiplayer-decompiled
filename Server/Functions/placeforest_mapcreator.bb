Function placeforest_mapcreator%(arg0.forest, arg1#, arg2#, arg3#, arg4.rooms)
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
    Local local15%[4]
    Local local16.items
    Local local17%
    Local local18#
    Local local19%
    Local local20%
    Local local22%
    Local local23%
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
    local10[$01] = loadimage("GFX\map\forest\forest1h.png")
    local11[$01] = loadtexture("GFX\map\forest\forest1h_mask.png", $03)
    local10[$02] = loadimage("GFX\map\forest\forest2h.png")
    local11[$02] = loadtexture("GFX\map\forest\forest2h_mask.png", $03)
    local10[$03] = loadimage("GFX\map\forest\forest2Ch.png")
    local11[$03] = loadtexture("GFX\map\forest\forest2Ch_mask.png", $03)
    local10[$04] = loadimage("GFX\map\forest\forest3h.png")
    local11[$04] = loadtexture("GFX\map\forest\forest3h_mask.png", $03)
    local10[$05] = loadimage("GFX\map\forest\forest4h.png")
    local11[$05] = loadtexture("GFX\map\forest\forest4h_mask.png", $03)
    For local9 = $01 To $05 Step $01
        arg0\Field0[local9] = load_terrain(local10[local9], 0.03, local12, local13, local11[local9])
    Next
    freetexture(local12)
    freetexture(local13)
    arg0\Field1[$00] = loadmesh_strict("GFX\map\forest\detail\treetest4.b3d", $00)
    arg0\Field1[$01] = loadmesh_strict("GFX\map\forest\detail\rock.b3d", $00)
    arg0\Field1[$02] = loadmesh_strict("GFX\map\forest\detail\rock2.b3d", $00)
    arg0\Field1[$03] = loadmesh_strict("GFX\map\forest\detail\treetest5.b3d", $00)
    arg0\Field1[$04] = loadmesh_strict("GFX\map\forest\wall.b3d", $00)
    For local9 = $01 To $05 Step $01
        hideentity(arg0\Field0[local9])
    Next
    For local9 = $00 To $04 Step $01
        hideentity(arg0\Field1[local9])
    Next
    local8 = meshwidth(arg0\Field0[$01])
    local6 = (local2 / local8)
    debuglog("ForestINIT")
    For local0 = $00 To $09 Step $01
        For local1 = $00 To $09 Step $01
            If (arg0\Field2[((local1 * $0A) + local0)] > $00) Then
                local3 = $00
                local14 = $00
                local3 = (Int ceil(((Float arg0\Field2[((local1 * $0A) + local0)]) / 4.0)))
                If (local3 = $06) Then
                    local3 = $02
                EndIf
                local14 = ((arg0\Field2[((local1 * $0A) + local0)] Mod $04) * $5A)
                local4 = copyentity(arg0\Field0[local3], $00)
                debuglog(((("Tile: " + (Str local3)) + "| Angle: ") + (Str local14)))
                If (local3 > $00) Then
                    local16 = Null
                    If ((((local1 Mod $03) = $02) And (local15[(Int floor((Float (local1 / $03))))] = $00)) <> 0) Then
                        local15[(Int floor((Float (local1 / $03))))] = $01
                        local16 = createitem(("Log #" + (Str (Int (floor((Float (local1 / $03))) + 1.0)))), "paper", 0.0, 0.5, 0.0, $00, $00, $00, 1.0, $00, $01)
                        entityparent(local16\Field1, local4, $01)
                    EndIf
                    setbuffer(imagebuffer(local10[local3], $00))
                    local17 = imagewidth(local10[local3])
                    local18 = (local8 / (Float local17))
                    For local19 = $03 To (local17 - $02) Step $01
                        For local20 = $03 To (local17 - $02) Step $01
                            getcolor(local19, (local17 - local20))
                            If (colorred() > rand($64, $104)) Then
                                local5 = $00
                                Select rand($00, $07)
                                    Case $00,$01,$02,$03,$04,$05,$06
                                        local5 = copyentity(arg0\Field1[$00], $00)
                                        local7 = rnd(0.25, 0.4)
                                        For local9 = $00 To $03 Step $01
                                            local22 = copyentity(arg0\Field1[$03], $00)
                                            rotateentity(local22, 0.0, (rnd(-20.0, 20.0) + (Float ($5A * local9))), 0.0, $00)
                                            entityparent(local22, local5, $01)
                                            entityfx(local22, $01)
                                        Next
                                        scaleentity(local5, (local7 * 1.1), local7, (local7 * 1.1), $01)
                                        positionentity(local5, (((Float local19) * local18) - (local8 / 2.0)), (((Float colorred()) * 0.03) - rnd(3.0, 3.2)), (((Float local20) * local18) - (local8 / 2.0)), $01)
                                        rotateentity(local5, rnd(-5.0, 5.0), rnd(360.0, 0.0), 0.0, $01)
                                    Case $07
                                        local5 = copyentity(arg0\Field1[$01], $00)
                                        local7 = rnd(0.01, 0.012)
                                        positionentity(local5, (((Float local19) * local18) - (local8 / 2.0)), (((Float colorred()) * 0.03) - 1.3), (((Float local20) * local18) - (local8 / 2.0)), $01)
                                        entityfx(local5, $01)
                                        rotateentity(local5, 0.0, rnd(360.0, 0.0), 0.0, $01)
                                    Case $06
                                        local5 = copyentity(arg0\Field1[$03], $00)
                                        local7 = rnd(0.1, 0.12)
                                        scaleentity(local5, local7, local7, local7, $01)
                                        positionentity(local5, (((Float local19) * local18) - (local8 / 2.0)), (((Float colorred()) * 0.03) - 1.3), (((Float local20) * local18) - (local8 / 2.0)), $01)
                                End Select
                                If (local5 <> $00) Then
                                    entityfx(local5, $01)
                                    entityparent(local5, local4, $01)
                                EndIf
                            EndIf
                        Next
                    Next
                    setbuffer(backbuffer())
                    turnentity(local4, 0.0, (Float local14), 0.0, $00)
                    positionentity(local4, (((Float local0) * local2) + arg1), arg2, (((Float local1) * local2) + arg3), $01)
                    debuglog(((((("tile_entity: " + (Str (((Float local0) * local2) + arg1))) + "|") + (Str arg2)) + "|") + (Str (((Float local1) * local2) + arg3))))
                    scaleentity(local4, local6, local6, local6, $00)
                    entitytype(local4, $01, $00)
                    entityfx(local4, $01)
                    entityparent(local4, arg0\Field4, $01)
                    entitypickmode(local4, $02, $01)
                    If (local16 <> Null) Then
                        entityparent(local16\Field1, $00, $01)
                    EndIf
                    arg0\Field3[((local1 * $0A) + local0)] = local4
                Else
                    debuglog(((((("INVALID TILE @ (" + (Str local0)) + ", ") + (Str local1)) + "): ") + (Str local3)))
                EndIf
                If (6.0 = ceil(((Float arg0\Field2[((local1 * $0A) + local0)]) / 4.0))) Then
                    For local9 = $00 To $01 Step $01
                        If (arg0\Field5[local9] = $00) Then
                            arg0\Field6[local9] = copyentity(arg0\Field1[$04], $00)
                            scaleentity(arg0\Field6[local9], roomscale, roomscale, roomscale, $00)
                            arg0\Field5[local9] = copyentity(arg4\Field25[$03], $00)
                            positionentity(arg0\Field5[local9], (72.0 * roomscale), (32.0 * roomscale), 0.0, $01)
                            rotateentity(arg0\Field5[local9], 0.0, 180.0, 0.0, $00)
                            scaleentity(arg0\Field5[local9], (48.0 * roomscale), (45.0 * roomscale), (48.0 * roomscale), $01)
                            entityparent(arg0\Field5[local9], arg0\Field6[local9], $01)
                            local23 = copyentity(arg4\Field25[$02], arg0\Field5[local9])
                            positionentity(local23, 0.0, (32.0 * roomscale), 0.0, $01)
                            scaleentity(local23, (48.0 * roomscale), (45.0 * roomscale), (48.0 * roomscale), $01)
                            entityparent(local23, arg0\Field6[local9], $01)
                            entitytype(arg0\Field6[local9], $01, $00)
                            entitypickmode(arg0\Field6[local9], $02, $01)
                            positionentity(arg0\Field6[local9], (((Float local0) * local2) + arg1), arg2, (((Float local1) * local2) + arg3), $01)
                            rotateentity(arg0\Field6[local9], 0.0, (Float (local14 + $B4)), 0.0, $00)
                            moveentity(arg0\Field6[local9], 0.0, 0.0, -6.0)
                            entityparent(arg0\Field6[local9], arg0\Field4, $01)
                            Exit
                        EndIf
                    Next
                EndIf
            Else
                debuglog((((("NO TILE FOUND @ (" + (Str local0)) + ", ") + (Str local1)) + ")"))
            EndIf
        Next
    Next
    For local9 = $01 To $05 Step $01
        freeimage(local10[local9])
        freetexture(local11[local9])
    Next
    debuglog("ForestINIT END")
    Return $00
End Function
