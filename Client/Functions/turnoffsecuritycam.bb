Function turnoffsecuritycam%(arg0.rooms, arg1%)
    Local local0.securitycams
    For local0 = Each securitycams
        If (local0\Field16 = arg0) Then
            If (arg1 <> 0) Then
                If (local0\Field5 <> 0) Then
                    If (local0\Field18 <> $01) Then
                        local0\Field18 = $00
                    EndIf
                    hideentity(local0\Field7)
                    hideentity(local0\Field4)
                    local0\Field5 = $00
                EndIf
            ElseIf (local0\Field5 = $00) Then
                If (local0\Field18 = $00) Then
                    local0\Field18 = $02
                EndIf
                showentity(local0\Field7)
                showentity(local0\Field4)
                local0\Field5 = $01
            EndIf
            Exit
        EndIf
    Next
    Return $00
End Function
