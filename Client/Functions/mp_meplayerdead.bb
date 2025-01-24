Function mp_meplayerdead%(arg0%)
    Local local1%
    If (mp_getsocket() = $00) Then
        Return $00
    EndIf
    mp_terminated\Field3 = (millisecs() + mp_terminated\Field5)
    mp_terminated\Field4 = me\Field59
    Select playerroom\Field7\Field1
        Case $47
            mp_terminated\Field4 = $C8
        Case $49
            mp_terminated\Field4 = $C9
    End Select
    If (mp_terminated\Field0 <> 0) Then
        If (t\Field3[$0A] <> $00) Then
            freeentity(t\Field3[$0A])
            t\Field3[$0A] = $00
        EndIf
    EndIf
    mp_terminated\Field6 = 280.0
    If (arg0 <> 0) Then
        mp_client_requestterminate()
    EndIf
    For local1 = $00 To (maxitemamount - $01) Step $01
        inventory(local1) = Null
    Next
    selectedcorpse = Null
    Return $00
End Function
