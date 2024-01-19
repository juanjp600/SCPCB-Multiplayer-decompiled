Function updatechunks%(arg0.rooms, arg1%, arg2%, arg3%, arg4.players)
    Local local0.chunk
    Local local1$
    Local local2%
    Local local3#
    Local local4#
    Local local5.chunk
    Local local6#
    Local local7%
    Local local8%
    Local local9#
    Local local10#
    Local local11#
    Local local12%
    Local local13%
    Local local14%
    local11 = 120.0
    If (1000.0 < distance(entityx(arg3, $00), entityz(arg3, $00), 8.0, 0.0)) Then
        arg4\Field0 = 8.0
        arg4\Field1 = 805.0
        arg4\Field2 = 0.0
        arg4\Field32 = arg0\Field69
        mp_updateplayerposition(arg4, $00)
    EndIf
    local9 = (Float (Int (entityx(arg3, $00) / 40.0)))
    local10 = (Float (Int (entityz(arg3, $00) / 40.0)))
    local6 = entityy(dimension1499\Field1\Field2, $00)
    local3 = ((local9 * 40.0) + (- local11))
    local4 = ((local10 * 40.0) + (- local11))
    local12 = $00
    local13 = getiniint("Data\1499chunks.INI", "general", "count", $00)
    Repeat
        local14 = $00
        For local0 = Each chunk
            If (local3 = local0\Field1) Then
                If (local4 = local0\Field2) Then
                    local14 = $01
                    Exit
                EndIf
            EndIf
        Next
        If (local14 = $00) Then
            local12 = chunkdata((Int (Abs (((local3 + 32.0) / 40.0) Mod 64.0))), (Int (Abs (((local4 + 32.0) / 40.0) Mod 64.0))))
            local5 = createchunk(local12, local3, local6, local4, $00)
            local5\Field5 = $00
        EndIf
        local3 = (local3 + 40.0)
        If (local3 > ((local9 * 40.0) + local11)) Then
            local4 = (local4 + 40.0)
            local3 = ((local9 * 40.0) + (- local11))
        EndIf
    Until (local4 > ((local10 * 40.0) + local11))
    For local0 = Each chunk
        If (local0\Field5 = $00) Then
            If (local11 < distance(entityx(arg3, $00), entityz(arg3, $00), entityx(local0\Field6, $00), entityz(local0\Field6, $00))) Then
                freeentity(local0\Field6)
                Delete local0
            EndIf
        EndIf
    Next
    Return $00
End Function
