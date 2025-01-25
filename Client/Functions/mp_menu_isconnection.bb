Function mp_menu_isconnection%()
    Return ((mp_menugetip() <> $00) Lor (mp_getsocket() <> $00))
    Return $00
End Function
