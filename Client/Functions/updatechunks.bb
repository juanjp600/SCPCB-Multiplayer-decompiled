Function updatechunks%(arg0.rooms, arg1%, arg2%)
    Local local0.chunk
    Local local1.chunk
    Local local2%
    Local local3#
    Local local4#
    Local local5#
    Local local6#
    Local local7#
    Local local8%
    Local local9%
    Local local10#
    Local local11#
    Local local12#
    Local local13#
    Local local14%
    Local local15%
    Local local16#
    local6 = 120.0
    local7 = 40.0
    local8 = (Int floor((entityx(collider, $00) * 0.025)))
    local9 = (Int floor((entityz(collider, $00) * 0.025)))
    local5 = entityy(dimension1499\Field1\Field3, $00)
    local10 = (((Float local8) * local7) - local6)
    local11 = (((Float local9) * local7) - local6)
    local12 = (((Float local8) * local7) + local6)
    local13 = (((Float local9) * local7) + local6)
    local3 = local10
    local4 = local11
    Repeat
        local14 = $00
        For local0 = Each chunk
            If (0.1 > (Abs (local0\Field1 - local3))) Then
                If (0.1 > (Abs (local0\Field2 - local4))) Then
                    local14 = $01
                    Exit
                EndIf
            EndIf
        Next
        If (local14 = $00) Then
            local15 = chunkdata((Int (Abs (floor(((local3 + 32.0) * 0.025)) Mod 64.0))), (Int (Abs (floor(((local4 + 32.0) * 0.025)) Mod 64.0))))
            local1 = createchunk(local15, local3, local5, local4, $00)
            local1\Field1 = local3
            local1\Field2 = local4
            local1\Field5 = $00
        EndIf
        local3 = (local3 + local7)
        If (local3 > (local12 + 1.0)) Then
            local3 = local10
            local4 = (local4 + local7)
        EndIf
    Until (local4 > (local13 + 1.0))
    local16 = (local6 + 20.0)
    For local0 = Each chunk
        If (local0\Field5 = $00) Then
            If (local16 < entitydistance(collider, local0\Field6)) Then
                For local2 = $00 To local0\Field4 Step $01
                    freeentity(local0\Field0[local2])
                Next
                freeentity(local0\Field7)
                freeentity(local0\Field6)
                Delete local0
            EndIf
        EndIf
    Next
    Return $00
End Function
