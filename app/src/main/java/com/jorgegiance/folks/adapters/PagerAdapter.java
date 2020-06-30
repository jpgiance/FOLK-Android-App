package com.jorgegiance.folks.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.jorgegiance.folks.ui.fragments.CongressFragment;
import com.jorgegiance.folks.ui.fragments.ContentFragment;
import com.jorgegiance.folks.ui.fragments.DebateFragment;
import com.jorgegiance.folks.ui.fragments.LocalFragment;
import com.jorgegiance.folks.ui.fragments.MemberCommentsFragment;
import com.jorgegiance.folks.ui.fragments.MemberMediaFragment;
import com.jorgegiance.folks.ui.fragments.MemberProfileFragment;
import com.jorgegiance.folks.ui.fragments.StatesFragment;
import com.jorgegiance.folks.ui.fragments.UserFollowingFragment;
import com.jorgegiance.folks.ui.fragments.UserProfileFragment;
import com.jorgegiance.folks.ui.fragments.UserSettingsFragment;

public class PagerAdapter extends FragmentStateAdapter {

    private final Context mContext;
    private boolean isFromUserActivity, isFromPeopleActivity, isFromMemberDetailActivity, isFromDetailHomeActivity;

    public PagerAdapter( @NonNull FragmentActivity fragmentActivity, Context mContext, boolean fromUserActivity, boolean fromPeopleActivity, boolean fromMemberDetailActivity, boolean fromDetailHomeActivity ) {
        super(fragmentActivity);
        this.mContext = mContext;
        this.isFromUserActivity = fromUserActivity;
        this.isFromPeopleActivity = fromPeopleActivity;
        this.isFromDetailHomeActivity = fromDetailHomeActivity;
        this.isFromMemberDetailActivity = fromMemberDetailActivity;
    }

    @NonNull
    @Override
    public Fragment createFragment( int position ) {
        switch (position){
            case 0:
                if (isFromUserActivity){
                    return new UserProfileFragment();
                }else if (isFromPeopleActivity){
                    return new StatesFragment();
                }else if (isFromDetailHomeActivity){
                    return new ContentFragment();
                }else if (isFromMemberDetailActivity){
                    return new MemberProfileFragment();
                }

            case 1:
                if (isFromUserActivity){
                    return new UserFollowingFragment();
                }else if (isFromPeopleActivity){
                    return new CongressFragment();
                }else if (isFromDetailHomeActivity){
                    return new DebateFragment();
                }else if (isFromMemberDetailActivity){
                    return new MemberMediaFragment();
                }
            case 2:
                if (isFromUserActivity){
                    return new UserSettingsFragment();
                }else if (isFromPeopleActivity){
                    return new LocalFragment();
                }else if (isFromDetailHomeActivity){

                }else if (isFromMemberDetailActivity){
                    return new MemberCommentsFragment();
                }
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        if (isFromUserActivity){
            return 3;
        }else if (isFromPeopleActivity){
            return 3;
        }else if (isFromDetailHomeActivity){
            return 2;
        }else if (isFromMemberDetailActivity){
            return 3;
        }
        return 0;
    }
}
