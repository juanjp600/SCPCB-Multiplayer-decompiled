Function mp_analyzeroomlevers%(arg0.rooms)
    Local local0.levers
    Local local1.mp_roomlever
    Local local2%
    Local local3#
    Local local4#
    Local local5#
    For local2 = $00 To $03 Step $01
        If (arg0\Field13[local2] <> Null) Then
            local0 = arg0\Field13[local2]
            local1 = arg0\Field33[local2]
            local3 = entitypitch(local0\Field0, $01)
            local4 = entityyaw(local0\Field0, $01)
            local5 = entityroll(local0\Field0, $01)
            If (local1 = Null) Then
                local1 = (New mp_roomlever)
                local1\Field2 = local3
                local1\Field3 = local4
                local1\Field4 = local5
                local1\Field5 = local1\Field2
                local1\Field6 = local1\Field3
                local1\Field7 = local1\Field4
                local1\Field8 = $00
                local1\Field1 = local2
                local1\Field0 = arg0
                arg0\Field33[local2] = local1
            Else
                local1\Field8 = (((local3 <> local1\Field2) + ((local4 <> local1\Field3) Shl $01)) + ((local5 <> local1\Field4) Shl $02))
                If (local1\Field8 > $00) Then
                    local1\Field9 = $01
                EndIf
            EndIf
        ElseIf (arg0\Field33[local2] <> Null) Then
            Delete arg0\Field33[local2]
        EndIf
    Next
    Return $00
End Function
