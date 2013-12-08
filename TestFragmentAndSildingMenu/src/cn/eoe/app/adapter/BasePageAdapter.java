package cn.eoe.app.adapter;

import java.util.ArrayList;
import java.util.List;

import cn.eoe.app.fragment.HttpErrorFragment;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

public class BasePageAdapter extends FragmentStatePagerAdapter {

	public ArrayList<Fragment> mFragments = new ArrayList<Fragment>();;
	public List<String> tabs = new ArrayList<String>();

	private Activity mActivity;

	public BasePageAdapter(FragmentActivity activity) {
		super(activity.getSupportFragmentManager());
		this.mActivity = activity;
	}



	public void Clear() {
		mFragments.clear();
		tabs.clear();
	}

	public void addTab(Fragment fragment) {
		mFragments.add(fragment);
		notifyDataSetChanged();
	}
	public void addFragment(List<String> mList) {
		// TODO Auto-generated method stub
		tabs.addAll(mList);
		for (int i = 0; i < tabs.size(); i++) {
			addTab(new HttpErrorFragment());
		}
	}
	@Override
	public CharSequence getPageTitle(int position) {
		return tabs.get(position);
	}

	@Override
	public Fragment getItem(int arg0) {
		return mFragments.get(arg0);
	}

	@Override
	public int getCount() {
		return mFragments.size();
	}

	@Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}

	//

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		super.destroyItem(container, position, object);
	}
}
