Function showroomsnocoll%(arg0.rooms)
    Local local0%
    Local local1.props
    Local local2.doors
    Local local3.securitycams
    Local local4.levers
    If (entityhidden(arg0\Field2) <> 0) Then
        For local1 = Each props
            If (local1\Field2 = arg0) Then
                showentity(local1\Field1)
            EndIf
        Next
        For local2 = Each doors
            If (local2\Field15 = arg0) Then
                showentity(local2\Field0)
                If (local2\Field1 <> $00) Then
                    showentity(local2\Field1)
                EndIf
                For local0 = $00 To $01 Step $01
                    If (local2\Field3[local0] <> $00) Then
                        showentity(local2\Field3[local0])
                    EndIf
                    If (local2\Field24[local0] <> $00) Then
                        showentity(local2\Field24[local0])
                    EndIf
                Next
                showentity(local2\Field2)
            EndIf
        Next
        For local3 = Each securitycams
            If (local3\Field16 = arg0) Then
                If (local3\Field2 <> $00) Then
                    If (local3\Field21 = $00) Then
                        showentity(local3\Field2)
                    EndIf
                EndIf
                If (local3\Field22 = $00) Then
                    showentity(local3\Field1)
                    showentity(local3\Field0)
                EndIf
            EndIf
        Next
        For local4 = Each levers
            If (local4\Field2 = arg0) Then
                showentity(local4\Field0)
                showentity(local4\Field1)
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
        showentity(arg0\Field2)
    EndIf
    Return $00
End Function
