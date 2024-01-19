Function createdoor.doors(arg0%, arg1#, arg2#, arg3#, arg4#, arg5.rooms, arg6%, arg7%, arg8%, arg9$, arg10%)
    Local local0.doors
    Local local1%
    Local local2%
    Local local3.doors
    Local local4.roomsdoorsline
    If (arg5 <> Null) Then
        local1 = arg5\Field2
    EndIf
    local0 = (New doors)
    If (arg7 = $01) Then
        local0\Field0 = copyentity(bigdoorobj($00), $00)
        scaleentity(local0\Field0, (55.0 * roomscale), (55.0 * roomscale), (55.0 * roomscale), $00)
        local0\Field1 = copyentity(bigdoorobj($01), $00)
        scaleentity(local0\Field1, (55.0 * roomscale), (55.0 * roomscale), (55.0 * roomscale), $00)
        local0\Field2 = copyentity(doorcoll, $00)
        scaleentity(local0\Field2, roomscale, roomscale, roomscale, $00)
        entitytype(local0\Field2, $0B, $00)
        entityalpha(local0\Field2, 0.0)
    ElseIf (arg7 = $02) Then
        local0\Field0 = copyentity(heavydoorobj($00), $00)
        scaleentity(local0\Field0, roomscale, roomscale, roomscale, $00)
        local0\Field1 = copyentity(heavydoorobj($01), $00)
        scaleentity(local0\Field1, roomscale, roomscale, roomscale, $00)
        local0\Field2 = copyentity(doorframeobj, $00)
    ElseIf (arg7 = $03) Then
        For local3 = Each doors
            If (((local3 <> local0) And (local3\Field9 = $03)) <> 0) Then
                local0\Field0 = copyentity(local3\Field0, $00)
                local0\Field1 = copyentity(local3\Field1, $00)
                scaleentity(local0\Field0, roomscale, roomscale, roomscale, $00)
                scaleentity(local0\Field1, roomscale, roomscale, roomscale, $00)
                Exit
            EndIf
        Next
        If (local0\Field0 = $00) Then
            local0\Field0 = loadmesh_strict("GFX\map\elevatordoor.b3d", $00)
            local0\Field1 = copyentity(local0\Field0, $00)
            scaleentity(local0\Field0, roomscale, roomscale, roomscale, $00)
            scaleentity(local0\Field1, roomscale, roomscale, roomscale, $00)
        EndIf
        local0\Field2 = copyentity(doorframeobj, $00)
    Else
        local0\Field0 = copyentity(doorobj, $00)
        scaleentity(local0\Field0, ((204.0 * roomscale) / meshwidth(local0\Field0)), ((312.0 * roomscale) / meshheight(local0\Field0)), ((16.0 * roomscale) / meshdepth(local0\Field0)), $00)
        local0\Field2 = copyentity(doorframeobj, $00)
        local0\Field1 = copyentity(doorobj, $00)
        scaleentity(local0\Field1, ((204.0 * roomscale) / meshwidth(local0\Field0)), ((312.0 * roomscale) / meshheight(local0\Field0)), ((16.0 * roomscale) / meshdepth(local0\Field0)), $00)
    EndIf
    positionentity(local0\Field2, arg1, arg2, arg3, $00)
    scaleentity(local0\Field2, (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
    entitypickmode(local0\Field2, $02, $01)
    entitytype(local0\Field0, $0B, $00)
    entitytype(local0\Field1, $0B, $00)
    local0\Field18 = findfreedoorid()
    multiplayer_door[local0\Field18] = local0
    local0\Field12 = arg8
    local0\Field17 = arg9
    local0\Field19 = arg0
    local0\Field20 = $42
    For local2 = $00 To $01 Step $01
        If (arg9 <> "") Then
            local0\Field3[local2] = copyentity(buttoncodeobj, $00)
            entityfx(local0\Field3[local2], $01)
        ElseIf (arg8 > $00) Then
            local0\Field3[local2] = copyentity(buttonkeyobj, $00)
        ElseIf (arg8 < $00) Then
            local0\Field3[local2] = copyentity(buttonscannerobj, $00)
        Else
            local0\Field3[local2] = copyentity(buttonobj, $00)
        EndIf
        scaleentity(local0\Field3[local2], 0.03, 0.03, 0.03, $00)
    Next
    If (arg7 = $01) Then
        positionentity(local0\Field3[$00], (arg1 - (432.0 * roomscale)), (arg2 + 0.7), ((192.0 * roomscale) + arg3), $00)
        positionentity(local0\Field3[$01], ((432.0 * roomscale) + arg1), (arg2 + 0.7), (arg3 - (192.0 * roomscale)), $00)
        rotateentity(local0\Field3[$00], 0.0, 90.0, 0.0, $00)
        rotateentity(local0\Field3[$01], 0.0, 270.0, 0.0, $00)
    Else
        positionentity(local0\Field3[$00], (arg1 + 0.6), (arg2 + 0.7), (arg3 - 0.1), $00)
        positionentity(local0\Field3[$01], (arg1 - 0.6), (arg2 + 0.7), (arg3 + 0.1), $00)
        rotateentity(local0\Field3[$01], 0.0, 180.0, 0.0, $00)
    EndIf
    entityparent(local0\Field3[$00], local0\Field2, $01)
    entityparent(local0\Field3[$01], local0\Field2, $01)
    positionentity(local0\Field0, arg1, arg2, arg3, $00)
    local0\Field29 = arg1
    local0\Field30 = arg2
    local0\Field31 = arg3
    rotateentity(local0\Field0, 0.0, arg4, 0.0, $00)
    rotateentity(local0\Field2, 0.0, arg4, 0.0, $00)
    If (local0\Field1 <> $00) Then
        positionentity(local0\Field1, arg1, arg2, arg3, $00)
        If (arg7 = $01) Then
            rotateentity(local0\Field1, 0.0, arg4, 0.0, $00)
        Else
            rotateentity(local0\Field1, 0.0, (arg4 + 180.0), 0.0, $00)
        EndIf
        entityparent(local0\Field1, local1, $01)
    EndIf
    entityparent(local0\Field2, local1, $01)
    entityparent(local0\Field0, local1, $01)
    local0\Field6 = (Int arg4)
    local0\Field5 = arg6
    entitypickmode(local0\Field0, $02, $01)
    If (local0\Field1 <> $00) Then
        entitypickmode(local0\Field1, $02, $01)
    EndIf
    entitypickmode(local0\Field2, $02, $01)
    If (((local0\Field5 And (arg7 = $00)) And (rand($08, $01) = $01)) <> 0) Then
        local0\Field21 = $01
    EndIf
    local0\Field9 = arg7
    local0\Field13 = arg5
    local0\Field24 = $01
    If (arg10 <> 0) Then
        For local3 = Each doors
            If (local3 <> local0) Then
                If (local3\Field26 <> $00) Then
                    local0\Field26 = copyentity(local3\Field26, local0\Field2)
                    entityalpha(local0\Field26, 0.0)
                    entityfx(local0\Field26, $01)
                    entitytype(local0\Field26, $0B, $00)
                    entitycolor(local0\Field26, 255.0, 0.0, 0.0)
                    hideentity(local0\Field26)
                    Exit
                EndIf
            EndIf
        Next
        If (local0\Field26 = $00) Then
            local0\Field26 = loadmesh_strict("GFX\doorhit.b3d", local0\Field2)
            entityalpha(local0\Field26, 0.0)
            entityfx(local0\Field26, $01)
            entitytype(local0\Field26, $0B, $00)
            entitycolor(local0\Field26, 255.0, 0.0, 0.0)
            hideentity(local0\Field26)
        EndIf
    EndIf
    If (allowroomsdoorsinit <> 0) Then
        local4 = (New roomsdoorsline)
        local4\Field0 = local0
    EndIf
    Return local0
    Return Null
End Function
