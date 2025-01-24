Function mp_isconnected%()
    Return ((((ue_connection\Field0 = $00) And (ue_connection\Field1 = $00)) And (mp_getsocket() <> $00)) And (mp_getmyindex() > $00))
    Return $00
End Function
