Function mp_findinventoryitem%(arg0%)
    Local local0%
    For local0 = $00 To (maxitemamount - $01) Step $01
        If (((inventory(local0) <> Null) And (inventory(local0)\Field4\Field2 = arg0)) <> 0) Then
            Return inventory(local0)\Field19
        EndIf
    Next
    Return $00
    Return $00
End Function
