Function mp_analyzeroomobjects%(arg0.rooms)
    Local local0%
    Local local1.mp_roomobject
    Local local2%
    Local local3#
    Local local4#
    Local local5#
    Local local6#
    Local local7#
    Local local8#
    local0 = $00
    For local2 = $00 To $1D Step $01
        If (arg0\Field11[local2] <> $00) Then
            local0 = arg0\Field11[local2]
            local1 = arg0\Field32[local2]
            local3 = entityx(local0, $01)
            local4 = entityy(local0, $01)
            local5 = entityz(local0, $01)
            local6 = entitypitch(local0, $01)
            local7 = entityyaw(local0, $01)
            local8 = entityroll(local0, $01)
            If (local1 = Null) Then
                local1 = (New mp_roomobject)
                local1\Field2 = local3
                local1\Field3 = local4
                local1\Field4 = local5
                local1\Field5 = local6
                local1\Field6 = local7
                local1\Field7 = local8
                local1\Field8 = local1\Field2
                local1\Field9 = local1\Field3
                local1\Field10 = local1\Field4
                local1\Field11 = local1\Field5
                local1\Field12 = local1\Field6
                local1\Field13 = local1\Field7
                local1\Field14 = $00
                local1\Field1 = local2
                local1\Field0 = arg0
                arg0\Field32[local2] = local1
            Else
                local1\Field14 = ((((((local3 <> local1\Field2) + ((local4 <> local1\Field3) Shl $01)) + ((local5 <> local1\Field4) Shl $02)) + ((local6 <> local1\Field5) Shl $03)) + ((local7 <> local1\Field6) Shl $04)) + ((local8 <> local1\Field7) Shl $05))
                If (local1\Field14 > $00) Then
                    local1\Field15 = $01
                EndIf
            EndIf
        ElseIf (arg0\Field32[local2] <> Null) Then
            Delete arg0\Field32[local2]
        EndIf
    Next
    Return $00
End Function
