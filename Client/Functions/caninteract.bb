Function caninteract%()
    Return (((((((((((((menuopen = $00) And (invopen = $00)) And (otheropen = Null)) And (selecteddoor = Null)) And (lockmouse = $00)) And (consoleopen = $00)) And (using294 = $00)) And (selectedscreen = Null)) And (0.0 <= endingtimer)) And (networkserver\Field27 = $00)) And (spectate\Field1 = $FFFFFFFF)) And ((tab_menu_state >= $02) = $00)) Or mainmenuopen)
    Return $00
End Function
