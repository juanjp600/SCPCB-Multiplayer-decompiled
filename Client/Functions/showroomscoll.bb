Function showroomscoll%(arg0.rooms)
    Local local0%
    Local local1%
    Local local2%
    Local local3.props
    Local local4.doors
    Local local5.securitycams
    Local local6.levers
    If (arg0\Field29 <> 0) Then
        For local3 = Each props
            If (local3\Field2 = arg0) Then
                entityalpha(local3\Field1, 1.0)
            EndIf
        Next
        For local4 = Each doors
            If (local4\Field15 = arg0) Then
                entityalpha(local4\Field0, 1.0)
                If (local4\Field1 <> $00) Then
                    entityalpha(local4\Field1, 1.0)
                EndIf
                For local0 = $00 To $01 Step $01
                    If ((((local4\Field3[local0] <> $00) And (local4\Field10 <> $05)) And (local4\Field10 <> $04)) <> 0) Then
                        entityalpha(local4\Field3[local0], 1.0)
                    EndIf
                    If (local4\Field24[local0] <> $00) Then
                        showentity(local4\Field24[local0])
                    EndIf
                Next
                entityalpha(local4\Field2, 1.0)
            EndIf
        Next
        For local5 = Each securitycams
            If (local5\Field16 = arg0) Then
                If (local5\Field2 <> $00) Then
                    If (local5\Field21 = $00) Then
                        showentity(local5\Field2)
                    EndIf
                EndIf
                If (local5\Field22 = $00) Then
                    showentity(local5\Field1)
                    showentity(local5\Field0)
                EndIf
            EndIf
        Next
        For local6 = Each levers
            If (local6\Field2 = arg0) Then
                showentity(local6\Field0)
                showentity(local6\Field1)
            EndIf
        Next
        For local0 = $00 To $1D Step $01
            If (arg0\Field11[local0] <> $00) Then
                If (arg0\Field12[local0] = $00) Then
                    showentity(arg0\Field11[local0])
                EndIf
            Else
                Exit
            EndIf
        Next
        entityalpha(getchild(arg0\Field2, $02), 1.0)
        arg0\Field29 = $00
    EndIf
    Return $00
End Function
