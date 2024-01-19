Function showroomwithcollision%(arg0.rooms)
    Local local0%
    If (arg0\Field69 = $00) Then
        showentity(arg0\Field2)
        entityalpha(getchild(arg0\Field2, $02), 1.0)
        For local0 = $00 To arg0\Field76 Step $01
            entityalpha(arg0\Field75[local0], 1.0)
        Next
        If (debughud <> 0) Then
            If (arg0\Field40 > $00) Then
                For local0 = $00 To (arg0\Field40 - $01) Step $01
                    entitycolor(arg0\Field41[local0], 255.0, 255.0, 0.0)
                    entityalpha(arg0\Field41[local0], 0.2)
                Next
            EndIf
        ElseIf (arg0\Field40 > $00) Then
            For local0 = $00 To (arg0\Field40 - $01) Step $01
                entitycolor(arg0\Field41[local0], 255.0, 255.0, 255.0)
                entityalpha(arg0\Field41[local0], 0.0)
            Next
        EndIf
        arg0\Field69 = $01
    EndIf
    Return $00
End Function
