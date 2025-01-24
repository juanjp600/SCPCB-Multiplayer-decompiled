Function mp_client_analyzeitem%(arg0.items, arg1%)
    Local local0%
    Local local1%
    Local local2%
    Local local3.items
    local0 = $00
    If (arg1 = $00) Then
        If (((0.0 >= arg0\Field31) And (arg0\Field27 = mp_getmyindex())) <> 0) Then
            local3 = mp_items[arg0\Field26]
            If (local3 <> Null) Then
                If (mp_isiteminsecondinv(arg0, local3) = $00) Then
                    mp_pushitemtosecondinv(arg0, local3)
                EndIf
                For local1 = $00 To (maxitemamount - $01) Step $01
                    If (inventory(local1) = arg0) Then
                        inventory(local1) = Null
                        Exit
                    EndIf
                Next
            Else
                For local1 = $00 To (maxitemamount - $01) Step $01
                    If (inventory(local1) = arg0) Then
                        local0 = $01
                        Exit
                    EndIf
                Next
                If (local0 = $00) Then
                    For local1 = $00 To (maxitemamount - $01) Step $01
                        If (inventory(local1) = Null) Then
                            inventory(local1) = arg0
                            Exit
                        EndIf
                    Next
                EndIf
            EndIf
        EndIf
    Else
        For local1 = $00 To (maxitemamount - $01) Step $01
            If (inventory(local1) <> Null) Then
                If (inventory(local1) = arg0) Then
                    inventory(local1) = Null
                EndIf
                mp_removeitemfromsecondinv(arg0, inventory(local1))
            EndIf
        Next
        mp_assignitem(arg0, Null)
    EndIf
    Return $00
End Function
