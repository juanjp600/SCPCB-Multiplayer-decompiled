Function mp_connect%(arg0%, arg1%)
    directconnect(arg0, arg1)
    mp_resettimestep()
    Repeat
        mp_updatetimestep()
        mp_updateconnection()
        If (((mp_menu\Field2 <> $00) Lor (getnetworkserverip() <> $00)) <> 0) Then
            Exit
        EndIf
        delay($0A)
    Forever
    Return $00
End Function
